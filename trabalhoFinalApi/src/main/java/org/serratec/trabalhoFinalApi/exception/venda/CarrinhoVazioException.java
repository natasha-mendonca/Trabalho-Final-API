package org.serratec.trabalhoFinalApi.exception.venda;

import org.serratec.trabalhoFinalApi.exception.EcommerceException;

public class CarrinhoVazioException extends EcommerceException {

    public CarrinhoVazioException() {
        super("Não é possível finalizar a compra porque o carrinho está vazio.", "VEN-001");
    }
}