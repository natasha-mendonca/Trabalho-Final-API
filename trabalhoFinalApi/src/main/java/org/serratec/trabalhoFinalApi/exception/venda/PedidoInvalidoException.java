package org.serratec.trabalhoFinalApi.exception.venda;

import org.serratec.trabalhoFinalApi.exception.EcommerceException;

public class PedidoInvalidoException extends EcommerceException {

    public PedidoInvalidoException(String motivo) {
        super("Falha ao processar o pedido: " + motivo, "VEN-002");
    }
}