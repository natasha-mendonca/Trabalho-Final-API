package org.serratec.trabalhoFinalApi.model;

import lombok.Data;
import org.serratec.trabalhoFinalApi.entity.Endereco;

import java.util.UUID;

@Data
public class EnderecoBuscar {

    private UUID id;
    private String cep;
    private String logradouro;
    private String complemento;

    public EnderecoBuscar(Endereco endereco) {
        this.id = endereco.getId();
        this.cep = endereco.getCep();
        this.logradouro = endereco.getLogradouro();
        this.complemento = endereco.getComplemento();
    }
}
