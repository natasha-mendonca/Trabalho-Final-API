package org.serratec.trabalhoFinalApi.exception.infra;

import org.serratec.trabalhoFinalApi.exception.EcommerceException;

public class CepInvalidoException extends EcommerceException {
    public CepInvalidoException(String cep) {
        super("O CEP '" + cep + "' é inválido ou não foi encontrado.", "LOG-001");
    }
}