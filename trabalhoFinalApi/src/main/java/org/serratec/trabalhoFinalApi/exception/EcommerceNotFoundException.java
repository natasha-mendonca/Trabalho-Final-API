package org.serratec.trabalhoFinalApi.exception;

import org.springframework.http.HttpStatus;

public abstract class EcommerceNotFoundException extends EcommerceException{
    protected EcommerceNotFoundException(String mensagem, String codigo) {
        super(mensagem, codigo, HttpStatus.NOT_FOUND);
    }
}
