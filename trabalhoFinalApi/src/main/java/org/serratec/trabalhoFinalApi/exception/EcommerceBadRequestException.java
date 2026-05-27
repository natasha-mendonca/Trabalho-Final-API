package org.serratec.trabalhoFinalApi.exception;

import org.springframework.http.HttpStatus;

public abstract class EcommerceBadRequestException extends EcommerceException{
    protected EcommerceBadRequestException(String mensagem, String codigo) {
        super(mensagem, codigo, HttpStatus.BAD_REQUEST);
    }
}
