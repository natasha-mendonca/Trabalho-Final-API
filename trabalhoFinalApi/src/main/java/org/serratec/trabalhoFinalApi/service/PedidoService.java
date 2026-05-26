package org.serratec.trabalhoFinalApi.service;
import jakarta.persistence.EntityManager;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.serratec.trabalhoFinalApi.entity.Cliente;
import org.serratec.trabalhoFinalApi.entity.ItemPedido;
import org.serratec.trabalhoFinalApi.entity.Pedido;
import org.serratec.trabalhoFinalApi.entity.Produto;
import org.serratec.trabalhoFinalApi.model.ItemPedidoSolicitacao;
import org.serratec.trabalhoFinalApi.model.PedidoAtualiza;
import org.serratec.trabalhoFinalApi.model.PedidoBuscar;
import org.serratec.trabalhoFinalApi.model.PedidoCriar;
import org.serratec.trabalhoFinalApi.repository.ClienteRepository;
import org.serratec.trabalhoFinalApi.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class PedidoService {

    private PedidoRepository pedidoRepository;
    private ProdutoService produtoService;
    private ClienteRepository clienteRepository;
    private EmailService emailService;
    private EntityManager entityManager;

    public PedidoService(PedidoRepository pedidoRepository, ProdutoService produtoService, ClienteRepository clienteRepository, EmailService emailService, EntityManager entityManager) {
        this.pedidoRepository = pedidoRepository;
        this.produtoService = produtoService;
        this.clienteRepository = clienteRepository;
        this.emailService = emailService;
        this.entityManager = entityManager;
    }

    public Pedido buscarPedido(UUID id){
        return this.pedidoRepository.findById(id).orElseThrow(() -> new RuntimeException("Pedido não encontrado pelo id: " + id + " especificado. Informe outro!"));
    }

    public Cliente buscarCliente(UUID id){
        return this.clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente não encontrado pelo id: " + id + " especificado. Informe outro!"));
    }

    public List<Number> buscarRevisoes(UUID pedidoId) {
        AuditReader reader = AuditReaderFactory.get(entityManager);

        return reader.getRevisions(Pedido.class, pedidoId);
    }

    public Pedido inserirPedido(PedidoCriar pedidoCriar){

        Cliente clienteExistente = buscarCliente(pedidoCriar.getClienteId());
        Pedido pedido = new Pedido(pedidoCriar, clienteExistente);

        List<ItemPedido> itens = new ArrayList<>();

        for (ItemPedidoSolicitacao itemDTO : pedidoCriar.getItens()) {

            Produto produto = produtoService.buscarProdutoId(itemDTO.getProdutoId());

            produtoService.atualizarEstoque(produto.getId(), itemDTO.getQuantidade());

            ItemPedido item = new ItemPedido(pedido, produto, itemDTO);

            itens.add(item);
        }

        //rever esse setItens dentro do service!
        pedido.setItens(itens);
        Pedido pedidoSalvo = pedidoRepository.save(pedido);
        emailService.enviarEmailPedidoAprovado(clienteExistente.getEmail(), pedidoSalvo);

        return pedidoSalvo;
    }

    public PedidoBuscar listarPedido(UUID id){

        Pedido pedido = buscarPedido(id);

        return new PedidoBuscar(pedido);
    }

    public void atualizarPedido(UUID id, PedidoAtualiza pedidoAtualiza){
        Pedido pedidoExistente =  buscarPedido(id);

        pedidoExistente.atualizarDados(pedidoAtualiza);
        Pedido pedidoAtualizado = this.pedidoRepository.save(pedidoExistente);
        emailService.enviarEmailPedidoAtualizado(pedidoAtualizado.getCliente().getEmail(), pedidoAtualizado);
    }

    public void deletarPedido(UUID id){

        Pedido pedidoExistente =  buscarPedido(id);

        if(id == null){
            //exception aqui!
            System.out.println("Inform um id");
            return;
        }
        this.pedidoRepository.delete(pedidoExistente);
        emailService.enviarEmailPedidoCancelado(pedidoExistente.getCliente().getEmail(),
                pedidoExistente);

    }

}
