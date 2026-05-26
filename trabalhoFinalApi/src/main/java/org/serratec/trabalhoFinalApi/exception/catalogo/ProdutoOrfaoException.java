package org.serratec.trabalhoFinalApi.exception.catalogo;

import org.serratec.trabalhoFinalApi.exception.EcommerceException;

public class ProdutoOrfaoException extends EcommerceException {

    public ProdutoOrfaoException(String nomeProduto) {
        super("O produto '" + nomeProduto + "' não pode ser cadastrado sem uma categoria.", "CAT-004");
    }
}