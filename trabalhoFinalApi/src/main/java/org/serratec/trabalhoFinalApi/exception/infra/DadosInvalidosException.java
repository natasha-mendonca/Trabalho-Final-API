package org.serratec.trabalhoFinalApi.exception.infra;

import org.serratec.trabalhoFinalApi.exception.EcommerceBadRequestException;
import org.serratec.trabalhoFinalApi.exception.EcommerceException;

public class DadosInvalidosException extends EcommerceBadRequestException {

    public DadosInvalidosException(String detalhe) {
        super("Erro de validação nos dados de entrada: " + detalhe, "SYS-001");
    }
}