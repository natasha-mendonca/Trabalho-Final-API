package org.serratec.trabalhoFinalApi.exception.venda;

import org.serratec.trabalhoFinalApi.exception.EcommerceUnprocessableEntityException;

public class CarrinhoVazioException extends EcommerceUnprocessableEntityException {

    public CarrinhoVazioException() {
        super("Não é possível finalizar a compra porque o carrinho está vazio.", "VEN-001");
    }
}