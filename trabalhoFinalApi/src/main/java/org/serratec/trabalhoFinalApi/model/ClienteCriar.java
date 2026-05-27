package org.serratec.trabalhoFinalApi.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.serratec.trabalhoFinalApi.entity.Endereco;

import java.time.LocalDate;


@Schema (name = "ClienteCriar", description = "Dados necessários para cadastrar um novo cliente")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteCriar {

    @Schema (description = "Nome completo do cliente")
    @NotBlank
    @Size(max = 60)
    private String nome;

    @Schema (description = "CPF do cliente (somente números)")
    @NotBlank
    private String cpf;

    @Schema(description = "Data de nascimento do cliente") //ano/mes/dia
    @NotNull
    private LocalDate dataNascimento;

    @Schema (description = "E-mail do cliente")
    @Size(max=50)
    @Email
    @NotBlank
    private String email;

    @Schema (description = "Telefone do cliente")
    @NotBlank
    private String telefone;

    @Schema (description = "Endereço do cliente")
    private EnderecoCriar endereco;
}
