package org.serratec.trabalhoFinalApi.service;


// ------ NECESSITA CONECTAR COM A TABELA PRODUTO ---------


import org.serratec.trabalhoFinalApi.entity.ItemPedido;
import org.serratec.trabalhoFinalApi.entity.Pedido;
import org.serratec.trabalhoFinalApi.entity.Produto;
import org.serratec.trabalhoFinalApi.model.ItemPedidoSolicitacao;
import org.serratec.trabalhoFinalApi.model.PedidoAtualiza;
import org.serratec.trabalhoFinalApi.model.PedidoBuscar;
import org.serratec.trabalhoFinalApi.model.PedidoCriar;
import org.serratec.trabalhoFinalApi.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
public class PedidoService {

    private PedidoRepository pedidoRepository;
//    private ProdutoService produtoService;

//    @Autowired
//    private ItemPedidoService itemPedidoService;


//    public PedidoService(PedidoRepository pedidoRepository, ProdutoService produtoService) {
//        this.pedidoRepository = pedidoRepository;
//        this.produtoService = produtoService;
//    }

    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public Pedido buscarPedido(UUID id){
        return this.pedidoRepository.findById(id).orElseThrow(() -> new RuntimeException("Pedido não encontrado pelo id: " + id + " especificado. Informe outro!"));
    }

    public Pedido inserirPedido(PedidoCriar pedidoCriar){

        Pedido pedido = new Pedido(pedidoCriar);

        pedido.setDataPedido(LocalDateTime.now());

        List<ItemPedido> itens = new ArrayList<>();

        for (ItemPedidoSolicitacao itemDTO : pedidoCriar.getItens()) {

//            Produto produto = produtoService.buscarProduto(itemDTO.getProdutoId());

//            ItemPedido item = new ItemPedido(pedido, produto, itemDTO);

//            itens.add(item);
        }

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

}
