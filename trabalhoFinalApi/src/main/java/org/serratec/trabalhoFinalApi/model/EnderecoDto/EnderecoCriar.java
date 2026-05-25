package org.serratec.trabalhoFinalApi.model.EnderecoDto;

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

    @NotBlank(message = "O completo é obrigatório!")
    private String completo;

}
