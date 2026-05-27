package org.serratec.trabalhoFinalApi.exception.catalogo;

import org.serratec.trabalhoFinalApi.exception.EcommerceException;
import org.serratec.trabalhoFinalApi.exception.EcommerceNotFoundException;

import java.util.UUID;

public class CategoriaPaiNaoEncontradaException extends EcommerceNotFoundException {

    public CategoriaPaiNaoEncontradaException(UUID id) {
        super("A categoria superior (Pai) com ID " + id + " não existe.", "CAT-003");
    }
}