package org.serratec.trabalhoFinalApi.exception;

import org.springframework.http.HttpStatus;

public abstract class EcommerceConflictException extends EcommerceException{
    protected EcommerceConflictException(String mensagem, String codigo) {
        super(mensagem, codigo, HttpStatus.CONFLICT);
    }
}
