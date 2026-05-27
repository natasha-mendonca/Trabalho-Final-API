package org.serratec.trabalhoFinalApi.exception.catalogo;

import org.serratec.trabalhoFinalApi.exception.EcommerceBadRequestException;
import org.serratec.trabalhoFinalApi.exception.EcommerceException;
import org.serratec.trabalhoFinalApi.exception.EcommerceUnprocessableEntityException;

public class ProdutoOrfaoException extends EcommerceUnprocessableEntityException {

    public ProdutoOrfaoException(String nomeProduto) {
        super("O produto '" + nomeProduto + "' não pode ser cadastrado sem uma categoria.", "CAT-004");
    }
}