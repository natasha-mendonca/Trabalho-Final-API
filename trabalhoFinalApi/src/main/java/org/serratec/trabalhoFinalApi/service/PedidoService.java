package org.serratec.trabalhoFinalApi.service;

import jakarta.persistence.EntityManager;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.serratec.trabalhoFinalApi.entity.Cliente;
import org.serratec.trabalhoFinalApi.entity.ItemPedido;
import org.serratec.trabalhoFinalApi.entity.Pedido;
import org.serratec.trabalhoFinalApi.entity.Produto;
import org.serratec.trabalhoFinalApi.exception.generalista.RequisicaoNaoEncontradoException;
import org.serratec.trabalhoFinalApi.exception.usuario.ClienteNaoEncontradoException;
import org.serratec.trabalhoFinalApi.exception.venda.PedidoInvalidoException;
import org.serratec.trabalhoFinalApi.exception.venda.PedidoNaoEncontradoException;
import org.serratec.trabalhoFinalApi.model.*;
import org.serratec.trabalhoFinalApi.repository.ClienteRepository;
import org.serratec.trabalhoFinalApi.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
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

    @Value("${app.desconto.padrao}")
    private Double descontoPadrao;

    public PedidoService(PedidoRepository pedidoRepository, ProdutoService produtoService, ClienteRepository clienteRepository, EmailService emailService, EntityManager entityManager) {
        this.pedidoRepository = pedidoRepository;
        this.produtoService = produtoService;
        this.clienteRepository = clienteRepository;
        this.emailService = emailService;
        this.entityManager = entityManager;
    }

    public Pedido buscarPedido(UUID id){
        return this.pedidoRepository.findById(id).orElseThrow(() -> new PedidoNaoEncontradoException("O id: " + id + " especificado nao foi encontrado. Informe outro!"));
    }

    public Cliente buscarCliente(UUID id){
        return this.clienteRepository.findById(id).orElseThrow(() -> new ClienteNaoEncontradoException(id + " especificado. Informe outro!"));
    }

    public List<Number> buscarRevisoes(UUID pedidoId) {
        Pedido pedidoExistente = buscarPedido(pedidoId);

        AuditReader reader = AuditReaderFactory.get(entityManager);

        return reader.getRevisions(Pedido.class, pedidoId);
    }

    public PedidoRastreioResponse buscarPorCodigoRastreio(String codigoRastreio) {

        Pedido pedido = pedidoRepository
                .findByCodigoRastreio(codigoRastreio)
                .orElseThrow(()-> new RequisicaoNaoEncontradoException("Pedido com o código de rastreio: " + codigoRastreio));

        return new PedidoRastreioResponse(pedido);
    }

    public Pedido inserirPedido(PedidoCriar pedidoCriar){

        Cliente clienteExistente = buscarCliente(pedidoCriar.getClienteId());
        Pedido pedido = new Pedido(pedidoCriar, clienteExistente);

        List<ItemPedido> itens = new ArrayList<>();

        for (ItemPedidoSolicitacao itemDTO : pedidoCriar.getItens()) {

            Produto produto = produtoService.buscarProdutoId(itemDTO.getProdutoId());

            produtoService.atualizarEstoque(produto.getId(), itemDTO.getQuantidade());

            ItemPedido item = new ItemPedido(pedido, produto, itemDTO, descontoPadrao);

            itens.add(item);
        }

        pedido.setItens(itens);

        pedido.setCodigoRastreio("BR-" + UUID.randomUUID()
                .toString()
                .substring(0, 8)
                .toUpperCase());

        pedido.setPrevisaoEntrega(LocalDate.now().plusDays(7));

        Pedido pedidoSalvo = pedidoRepository.save(pedido);
        emailService.enviarEmailPedidoAprovado(clienteExistente.getEmail(), pedidoSalvo);

        return pedidoSalvo;
    }

    public PedidoBuscar encontrarPedido(UUID id){

        Pedido pedido = buscarPedido(id);

        return new PedidoBuscar(pedido);
    }

    public void atualizarPedido(UUID id, PedidoAtualiza pedidoAtualiza){
        Pedido pedidoExistente =  buscarPedido(id);

        if(pedidoAtualiza.getObservacoes() != null){
            pedidoExistente.setObservacoes(pedidoAtualiza.getObservacoes());
        }
        if(pedidoAtualiza.getFormasDePagamento() != null) {
            pedidoExistente.setFormaDePagamento(pedidoAtualiza.getFormasDePagamento());
        }
        if (pedidoAtualiza.getStatus() != null){
            pedidoExistente.setStatus(pedidoAtualiza.getStatus());
        }

        Pedido pedidoAtualizado = this.pedidoRepository.save(pedidoExistente);
        emailService.enviarEmailPedidoAtualizado(pedidoAtualizado.getCliente().getEmail(), pedidoAtualizado);
    }

    public void deletarPedido(UUID id){

        Pedido pedidoExistente =  buscarPedido(id);

        if(id == null){
            throw new PedidoInvalidoException("id não pode ser null");
        }
//        pedidoExistente.setDeletado(true);
        this.pedidoRepository.delete(pedidoExistente);
        emailService.enviarEmailPedidoCancelado(pedidoExistente.getCliente().getEmail(),
                pedidoExistente);

    }

}
