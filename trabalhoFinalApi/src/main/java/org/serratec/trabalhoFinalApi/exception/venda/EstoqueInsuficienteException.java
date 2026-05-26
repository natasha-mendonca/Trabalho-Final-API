package org.serratec.trabalhoFinalApi.exception.venda;

import org.serratec.trabalhoFinalApi.exception.EcommerceException;

public class EstoqueInsuficienteException extends EcommerceException {

    public EstoqueInsuficienteException(String produto, int disponivel) {
        super("Estoque insuficiente para o item: " + produto + ". Quantidade disponível: " + disponivel, "EST-001");
    }
}