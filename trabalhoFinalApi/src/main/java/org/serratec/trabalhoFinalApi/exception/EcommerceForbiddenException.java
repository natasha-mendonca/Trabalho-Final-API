package org.serratec.trabalhoFinalApi.exception;

import org.springframework.http.HttpStatus;

public abstract class EcommerceForbiddenException extends EcommerceException{
    protected EcommerceForbiddenException(String mensagem, String codigo) {
        super(mensagem, codigo, HttpStatus.FORBIDDEN);
    }
}
