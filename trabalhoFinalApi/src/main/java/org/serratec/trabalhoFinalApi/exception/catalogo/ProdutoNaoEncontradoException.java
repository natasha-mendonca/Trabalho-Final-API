package org.serratec.trabalhoFinalApi.exception.catalogo;

import org.serratec.trabalhoFinalApi.exception.EcommerceNotFoundException;

import java.util.UUID;


public class ProdutoNaoEncontradoException extends EcommerceNotFoundException {

    public ProdutoNaoEncontradoException(UUID identificador) {
        // Chama o construtor da mãe passando mensagem e o código CAT-404
        super("Produto com identificador " + identificador + " não foi encontrado.", "CAT-404");
    }
}