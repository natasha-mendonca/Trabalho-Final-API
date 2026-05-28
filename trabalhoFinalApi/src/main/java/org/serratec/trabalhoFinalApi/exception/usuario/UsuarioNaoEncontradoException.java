package org.serratec.trabalhoFinalApi.exception.usuario;

import org.serratec.trabalhoFinalApi.exception.EcommerceNotFoundException;

public class UsuarioNaoEncontradoException extends EcommerceNotFoundException {

    public UsuarioNaoEncontradoException(String login) {
        super("Usuário com o login '" + login + "' não foi encontrado no sistema.", "SEC-404");
    }
}