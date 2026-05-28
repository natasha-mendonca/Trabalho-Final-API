package org.serratec.trabalhoFinalApi.exception.catalogo;

import org.serratec.trabalhoFinalApi.exception.EcommerceConflictException;

public class NomeDuplicadoException extends EcommerceConflictException {

    public NomeDuplicadoException(String nome) {
        super("Já existe um registro cadastrado com o nome: " + nome, "CAT-001");
    }
}