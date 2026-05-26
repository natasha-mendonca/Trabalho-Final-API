package org.serratec.trabalhoFinalApi.exception.catalogo;

import org.serratec.trabalhoFinalApi.exception.EcommerceException;

public class NomeDuplicadoException extends EcommerceException {

    public NomeDuplicadoException(String nome) {
        super("Já existe um registro cadastrado com o nome: " + nome, "CAT-001");
    }
}