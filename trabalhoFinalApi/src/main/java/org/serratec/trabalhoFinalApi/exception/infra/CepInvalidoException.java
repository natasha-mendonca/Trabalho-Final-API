package org.serratec.trabalhoFinalApi.exception.infra;

import org.serratec.trabalhoFinalApi.exception.EcommerceBadRequestException;
import org.serratec.trabalhoFinalApi.exception.EcommerceException;
import org.springframework.http.HttpStatus;

public class CepInvalidoException extends EcommerceBadRequestException {
    public CepInvalidoException(String cep) {
        super("O CEP '" + cep + "' é inválido ou não foi encontrado.", "LOG-001");
    }
}