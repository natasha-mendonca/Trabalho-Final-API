package org.serratec.trabalhoFinalApi.model.ClienteDto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.serratec.trabalhoFinalApi.model.EnderecoDto.EnderecoCriar;

import java.time.LocalDate;


@Schema (name = "ClienteCriar", description = "Dados necessários para cadastrar um novo cliente")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteCriar {

    @Schema (description = "Nome completo do cliente")
    @NotBlank(message = "Nome nao deve estar em branco")
    @Size(max = 60, message = "O nome nao pode ultrapassar 60 caracteres")
    private String nome;

    @Schema (description = "CPF do cliente (somente números)", maxLength = 11)
    @NotBlank(message = "Cpf nao deve estar em branco")
    @Pattern(regexp = "\\d{11}", message = "Cpf deve ter exatamente 11 números.")
    private String cpf;

    @Schema(description = "Data de nascimento do cliente") //ano/mes/dia
    @NotNull(message = "Data de nascimento nao deve ser null")
    private LocalDate dataNascimento;

    @Schema (description = "E-mail do cliente")
    @Size(max=50, message = "O email nao pode ultrapassar 50 caracteres")
    @Email
    @NotBlank(message = "Email nao pode ser estar em branco")
    private String email;

    @Schema (description = "Telefone do cliente")
    @NotBlank(message = "Telefone nao deve estar em branco")
    @Pattern(regexp = "\\d{11}", message = "telefone deve ter exatamente 11 números.")
    private String telefone;

    @Schema (description = "Endereço do cliente", maxLength = 13)
    @NotNull(message = "Endereco nao deve estar em branco")
    @Valid
    private EnderecoCriar endereco;
}
