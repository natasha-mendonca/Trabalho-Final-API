package org.serratec.trabalhoFinalApi.exception.usuario;

import org.serratec.trabalhoFinalApi.exception.EcommerceConflictException;

public class EmailJaCadastradoException extends EcommerceConflictException {
    public EmailJaCadastradoException(String email) {

        super("O email " + email + " já está cadastrado no sistema.", "USR-005");
    }
}
