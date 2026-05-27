package org.serratec.trabalhoFinalApi.exception.generalista;

import org.serratec.trabalhoFinalApi.exception.EcommerceNotFoundException;

public class RequisicaoNaoEncontradoException extends EcommerceNotFoundException {

    public RequisicaoNaoEncontradoException(String motivo) {
        super("Falha ao tentar encontrar: " + motivo, "VEN-002");
    }
}