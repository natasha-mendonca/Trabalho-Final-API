package org.serratec.trabalhoFinalApi.exception.venda;

import org.serratec.trabalhoFinalApi.exception.EcommerceNotFoundException;

public class PedidoNaoEncontradoException extends EcommerceNotFoundException {

    public PedidoNaoEncontradoException(String motivo) {
        super("Falha tentar encontrar o pedido: " + motivo, "VEN-002");
    }
}