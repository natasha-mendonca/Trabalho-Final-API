package org.serratec.trabalhoFinalApi.exception.venda;

import org.serratec.trabalhoFinalApi.exception.EcommerceBadRequestException;

public class PedidoInvalidoException extends EcommerceBadRequestException {

    public PedidoInvalidoException(String motivo) {
        super("Falha ao processar o pedido: " + motivo, "VEN-002");
    }
}