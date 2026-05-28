package org.serratec.trabalhoFinalApi.exception.usuario;

import org.serratec.trabalhoFinalApi.exception.EcommerceForbiddenException;

public class AcessoNegadoException extends EcommerceForbiddenException {

    public AcessoNegadoException(String usuario) {
        super("O usuário '" + usuario + "' não tem permissão para acessar este recurso.", "SEC-403");
    }
}