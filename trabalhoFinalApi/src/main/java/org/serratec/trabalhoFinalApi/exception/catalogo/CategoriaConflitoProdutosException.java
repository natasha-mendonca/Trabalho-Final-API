package org.serratec.trabalhoFinalApi.exception.catalogo;

import org.serratec.trabalhoFinalApi.exception.EcommerceConflictException;

import java.util.UUID;

public class CategoriaConflitoProdutosException extends EcommerceConflictException {
    public CategoriaConflitoProdutosException(UUID id) {
        super("Categoria com ID " + id + " possui produtos vinculados. Não é possível deletar.", "CAT-004");
    }
}
