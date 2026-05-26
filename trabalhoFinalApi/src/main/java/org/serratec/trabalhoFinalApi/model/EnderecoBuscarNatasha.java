package org.serratec.trabalhoFinalApi.model;

import lombok.Data;
import org.serratec.trabalhoFinalApi.entity.EnderecoNatasha;
import java.util.UUID;

@Data

public class EnderecoBuscarNatasha {

    private UUID id;

    private String logradouro;

    private String cep;

    private String complemento;

    public EnderecoBuscarNatasha(EnderecoNatasha endereco) {
        this.id = endereco.getId();
        this.logradouro = endereco.getLogradouro();
        this.cep = endereco.getCep();
        this.complemento = endereco.getComplemento();
    }

}
