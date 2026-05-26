package org.serratec.trabalhoFinalApi.exception.catalogo;

import org.serratec.trabalhoFinalApi.exception.EcommerceException;

public class ProdutoNaoEncontradoException extends EcommerceException {

    public ProdutoNaoEncontradoException(String identificador) {
        // Chama o construtor da mãe passando mensagem e o código CAT-404
        super("Produto com identificador " + identificador + " não foi encontrado.", "CAT-404");
    }
}