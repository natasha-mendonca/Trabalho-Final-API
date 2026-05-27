package org.serratec.trabalhoFinalApi.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.serratec.trabalhoFinalApi.entity.Endereco;

import java.util.UUID;

@Data
public class EnderecoBuscar {

    @Schema(description = "Id do endereço")
    private UUID id;

    @Schema(description = "CEP do endereço")
    private String cep;

    @Schema(description = "Logradouro do endereço")
    private String logradouro;

    @Schema(description = "Complemento do endereço")
    private String complemento;

    public EnderecoBuscar(Endereco endereco) {
        this.id = endereco.getId();
        this.cep = endereco.getCep();
        this.logradouro = endereco.getLogradouro();
        this.complemento = endereco.getComplemento();
    }
}
