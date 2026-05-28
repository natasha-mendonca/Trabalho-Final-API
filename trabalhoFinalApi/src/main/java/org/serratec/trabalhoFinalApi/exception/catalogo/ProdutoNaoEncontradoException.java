package org.serratec.trabalhoFinalApi.exception.catalogo;

import org.serratec.trabalhoFinalApi.exception.EcommerceNotFoundException;

import java.util.UUID;


public class ProdutoNaoEncontradoException extends EcommerceNotFoundException {

    public ProdutoNaoEncontradoException(UUID identificador) {
        super("Produto com identificador " + identificador + " não foi encontrado.", "CAT-404");
    }
}