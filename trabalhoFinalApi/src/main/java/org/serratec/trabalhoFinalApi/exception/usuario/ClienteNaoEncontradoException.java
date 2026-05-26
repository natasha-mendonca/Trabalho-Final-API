package org.serratec.trabalhoFinalApi.exception.usuario;

import org.serratec.trabalhoFinalApi.exception.EcommerceException;

public class ClienteNaoEncontradoException extends EcommerceException {

    public ClienteNaoEncontradoException(String busca) {
        super("Cliente não localizado com o termo: " + busca, "USR-404");
    }
}