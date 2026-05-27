package org.serratec.trabalhoFinalApi.exception;

import org.springframework.http.HttpStatus;

public abstract class EcommerceException extends RuntimeException {
    private final String codigo;
    protected final HttpStatus status;

    public EcommerceException(String mensagem, String codigo, HttpStatus status) {
        super(mensagem);
        this.codigo = codigo;
        this.status = status;
    }

    public HttpStatus getStatus(){
        return this.status;
    }

    public String getCodigo() {
        return codigo;
    }
}
