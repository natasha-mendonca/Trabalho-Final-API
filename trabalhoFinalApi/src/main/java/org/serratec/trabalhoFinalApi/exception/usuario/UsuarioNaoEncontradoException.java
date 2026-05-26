package org.serratec.trabalhoFinalApi.exception.usuario;

import org.serratec.trabalhoFinalApi.exception.EcommerceException;

public class UsuarioNaoEncontradoException extends EcommerceException {

    public UsuarioNaoEncontradoException(String login) {
        super("Usuário com o login '" + login + "' não foi encontrado no sistema.", "SEC-404");
    }
}