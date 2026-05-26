package org.serratec.trabalhoFinalApi.exception.usuario;

import org.serratec.trabalhoFinalApi.exception.EcommerceException;

public class AcessoNegadoException extends EcommerceException {

    public AcessoNegadoException(String usuario) {
        // Código SEC-403 (Segurança - Forbidden/Proibido).
        super("O usuário '" + usuario + "' não tem permissão para acessar este recurso.", "SEC-403");
    }
}