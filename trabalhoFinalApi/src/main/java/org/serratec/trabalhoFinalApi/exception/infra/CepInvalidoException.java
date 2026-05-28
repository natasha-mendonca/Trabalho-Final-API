package org.serratec.trabalhoFinalApi.exception.infra;

import org.serratec.trabalhoFinalApi.exception.EcommerceBadRequestException;

public class CepInvalidoException extends EcommerceBadRequestException {
    public CepInvalidoException(String cep) {
        super("O CEP '" + cep + "' é inválido ou não foi encontrado.", "LOG-001");
    }
}