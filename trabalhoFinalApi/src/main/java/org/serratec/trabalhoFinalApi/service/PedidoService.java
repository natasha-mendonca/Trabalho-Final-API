package org.serratec.trabalhoFinalApi.service;

import org.serratec.trabalhoFinalApi.entity.Pedido;
import org.serratec.trabalhoFinalApi.model.PedidoCriar;
import org.serratec.trabalhoFinalApi.repository.PedidoRepository;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

    PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

//    public void inserirPedido(PedidoCriar pedidoCriar, Cliente cliente){
//
//        new Pedido(pedidoCriar);
//    }



}
