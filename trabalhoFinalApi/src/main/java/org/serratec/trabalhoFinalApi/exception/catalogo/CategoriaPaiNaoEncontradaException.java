package org.serratec.trabalhoFinalApi.exception.catalogo;

import org.serratec.trabalhoFinalApi.exception.EcommerceException;

public class CategoriaPaiNaoEncontradaException extends EcommerceException {

    public CategoriaPaiNaoEncontradaException(String id) {
        super("A categoria superior (Pai) com ID " + id + " não existe.", "CAT-003");
    }
}