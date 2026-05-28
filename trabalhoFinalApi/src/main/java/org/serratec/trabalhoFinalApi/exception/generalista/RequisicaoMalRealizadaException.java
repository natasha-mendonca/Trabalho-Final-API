package org.serratec.trabalhoFinalApi.exception.generalista;

import org.serratec.trabalhoFinalApi.exception.EcommerceBadRequestException;
import org.serratec.trabalhoFinalApi.exception.EcommerceNotFoundException;

public class RequisicaoMalRealizadaException extends EcommerceBadRequestException {

    public RequisicaoMalRealizadaException(String motivo) {
        super("Requisicao mal realizada: " + motivo, "VEN-002");
    }
}