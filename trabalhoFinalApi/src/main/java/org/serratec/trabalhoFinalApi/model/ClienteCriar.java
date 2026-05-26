package org.serratec.trabalhoFinalApi.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.serratec.trabalhoFinalApi.entity.Endereco;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteCriar {

    @NotBlank
    @Size(max = 60)
    private String nome;

    @NotBlank
    private String cpf;

    @Size(max=50)
    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String telefone;

    private EnderecoCriar endereco;
}
