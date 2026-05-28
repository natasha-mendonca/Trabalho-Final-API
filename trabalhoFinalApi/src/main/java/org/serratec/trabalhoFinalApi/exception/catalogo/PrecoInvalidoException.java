package org.serratec.trabalhoFinalApi.exception.catalogo;

import org.serratec.trabalhoFinalApi.exception.EcommerceBadRequestException;

public class PrecoInvalidoException extends EcommerceBadRequestException {

    public PrecoInvalidoException(double preco) {
        super("O preço informado (" + preco + ") é inválido. O valor deve ser maior que zero.", "CAT-002");
    }
}