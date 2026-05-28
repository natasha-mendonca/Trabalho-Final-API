package org.serratec.trabalhoFinalApi.exception.venda;

import org.serratec.trabalhoFinalApi.exception.EcommerceUnprocessableEntityException;

public class PagamentoRecusadoException extends EcommerceUnprocessableEntityException{

    public PagamentoRecusadoException(String formaPagamento) {
        super("O pagamento via " + formaPagamento + " foi recusado pela operadora.", "VEN-003");
    }
}