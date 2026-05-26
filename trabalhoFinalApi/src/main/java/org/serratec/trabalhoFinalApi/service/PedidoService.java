package org.serratec.trabalhoFinalApi.service;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class PedidoService {

    private PedidoRepository pedidoRepository;
    private ProdutoService produtoService;
    private ClienteRepository clienteRepository;

    private EntityManager entityManager;


    public PedidoService(PedidoRepository pedidoRepository, ProdutoService produtoService, ClienteRepository clienteRepository, EntityManager entityManager) {
        this.pedidoRepository = pedidoRepository;
        this.produtoService = produtoService;
        this.clienteRepository = clienteRepository;
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

//    public Pedido buscarPedidoNaRevisao(UUID id, Integer numeroRevisao) {
//        // 1. Criamos o leitor de auditoria do Envers passando o EntityManager
//        AuditReader auditReader = AuditReaderFactory.get(entityManager);
//
//        // 2. Fazemos a busca da entidade (Pedido.class), pelo ID e pelo número da revisão
//        Pedido pedidoHistorico = auditReader.find(Pedido.class, id, numeroRevisao);
//
//        // 3. Uma boa prática: se não achar a revisão, lançamos uma exceção
//        if (pedidoHistorico == null) {
//            throw new RuntimeException("Revisão " + numeroRevisao + " não encontrada para o pedido " + id);
//        }
//
//        return pedidoHistorico;
//    }


    public Pedido inserirPedido(PedidoCriar pedidoCriar){

        Cliente clienteExistente = buscarCliente(pedidoCriar.getClienteId());
        Pedido pedido = new Pedido(pedidoCriar, clienteExistente);

        List<ItemPedido> itens = new ArrayList<>();

        for (ItemPedidoSolicitacao itemDTO : pedidoCriar.getItens()) {

            Produto produto = produtoService.buscarProdutoId(itemDTO.getProdutoId());

            ItemPedido item = new ItemPedido(pedido, produto, itemDTO);

            itens.add(item);
        }

        //rever esse setItens dentro do service!
        pedido.setItens(itens);
        return pedidoRepository.save(pedido);
    }

    public PedidoBuscar listarPedido(UUID id){

        Pedido pedido = buscarPedido(id);

        return new PedidoBuscar(pedido);
    }

    public void atualizarPedido(UUID id, PedidoAtualiza pedidoAtualiza){
        Pedido pedidoExistente =  buscarPedido(id);

        pedidoExistente.atualizarDados(pedidoAtualiza);
        this.pedidoRepository.save(pedidoExistente);
    }


    public void deletarPedido(UUID id){

        Pedido pedidoExistente =  buscarPedido(id);

        if(id == null){
            //exception aqui!
            System.out.println("Inform um id");
            return;
        }
        this.pedidoRepository.delete(pedidoExistente);

    }

    //colocar o @Audited em todas as entidades do banco. Nao coloquei para nao ter a chance de dar conflito
    //alterei o POM e o Main tambem!

}
