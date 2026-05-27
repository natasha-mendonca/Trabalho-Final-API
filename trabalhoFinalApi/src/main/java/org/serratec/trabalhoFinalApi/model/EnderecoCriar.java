package org.serratec.trabalhoFinalApi.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Schema(name = "EnderecoCriar", description = "Dados necessários para cadastrar um endereço")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoCriar {

    @Schema (description = "CEP do endereço")
    @NotBlank(message = "O CEP é obrigatório!")
    private String cep;

    @Schema (description = "Complemento do endereço")
    @NotBlank(message = "O complemento é obrigatório!")
    private String complemento;

}
