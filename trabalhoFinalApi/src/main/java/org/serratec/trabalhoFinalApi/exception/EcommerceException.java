package org.serratec.trabalhoFinalApi.exception;

public abstract class EcommerceException extends RuntimeException {
    private final String codigo;

    public EcommerceException(String mensagem, String codigo) {
        super(mensagem);
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }
}
