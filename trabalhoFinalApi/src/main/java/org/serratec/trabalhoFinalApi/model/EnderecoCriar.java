package org.serratec.trabalhoFinalApi.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoCriar {

    @NotBlank(message = "O CEP é obrigatório!")
    private String cep;

    @NotBlank(message = "O complemento é obrigatório!")
    private String complemento;

}
