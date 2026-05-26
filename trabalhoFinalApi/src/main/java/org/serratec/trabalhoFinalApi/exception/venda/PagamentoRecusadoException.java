package org.serratec.trabalhoFinalApi.exception.venda;

import org.serratec.trabalhoFinalApi.exception.EcommerceException;

public class PagamentoRecusadoException extends EcommerceException {

    public PagamentoRecusadoException(String formaPagamento) {
        super("O pagamento via " + formaPagamento + " foi recusado pela operadora.", "VEN-003");
    }
}