package org.serratec.trabalhoFinalApi.exception.catalogo;

import org.serratec.trabalhoFinalApi.exception.EcommerceConflictException;

public class CategoriaJaCadastrada extends EcommerceConflictException {
    public CategoriaJaCadastrada(String nome) {
        super("A categoria " + nome + " já está cadastrado no sistema.", "CAT-005");
    }
}
