package org.serratec.trabalhoFinalApi.exception;

import org.springframework.http.HttpStatus;

public abstract class EcommerceUnprocessableEntityException extends EcommerceException{
    protected EcommerceUnprocessableEntityException(String mensagem, String codigo) {
        super(mensagem, codigo, HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
