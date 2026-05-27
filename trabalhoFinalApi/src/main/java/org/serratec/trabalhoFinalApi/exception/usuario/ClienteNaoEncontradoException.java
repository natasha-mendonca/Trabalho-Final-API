package org.serratec.trabalhoFinalApi.exception.usuario;

import org.serratec.trabalhoFinalApi.exception.EcommerceException;
import org.serratec.trabalhoFinalApi.exception.EcommerceNotFoundException;

public class ClienteNaoEncontradoException extends EcommerceNotFoundException {

    public ClienteNaoEncontradoException(String busca) {
        super("Cliente não localizado com o termo: " + busca, "USR-404");
    }
}