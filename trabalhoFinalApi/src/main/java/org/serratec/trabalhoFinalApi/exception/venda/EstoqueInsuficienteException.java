package org.serratec.trabalhoFinalApi.exception.venda;

import org.serratec.trabalhoFinalApi.exception.EcommerceException;
import org.serratec.trabalhoFinalApi.exception.EcommerceUnprocessableEntityException;

public class EstoqueInsuficienteException extends EcommerceUnprocessableEntityException {

    public EstoqueInsuficienteException(String produto, int disponivel) {
        super("Estoque insuficiente para o item: " + produto + ". Quantidade disponível: " + disponivel, "EST-001");
    }
}