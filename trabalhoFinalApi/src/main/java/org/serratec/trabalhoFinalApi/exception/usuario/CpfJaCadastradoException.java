package org.serratec.trabalhoFinalApi.exception.usuario;

import org.serratec.trabalhoFinalApi.exception.EcommerceConflictException;
import org.serratec.trabalhoFinalApi.exception.EcommerceException;

public class CpfJaCadastradoException extends EcommerceConflictException {
    public CpfJaCadastradoException(String cpf) {
        super("O CPF " + cpf + " já está cadastrado no sistema.", "USR-001");
    }
}