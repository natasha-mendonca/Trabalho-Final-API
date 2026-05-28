package org.serratec.trabalhoFinalApi.model.ClienteDto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.serratec.trabalhoFinalApi.entity.Cliente;
import org.serratec.trabalhoFinalApi.model.EnderecoDto.EnderecoCriar;

import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteAtualizar {

    @Schema(description = "Nome completo do cliente")
    private String nome;

    @Schema(description = "Data de nascimento do cliente")
    private LocalDate dataNascimento;

    @Schema(description = "Telefone do cliente", maxLength = 11)
    @Size(min = 11, max = 11, message = "O telefone deve conter exatamente 11 dígitos numéricos (DDD + Número)")
    private String telefone;

    @Schema(description = "Endereço do cliente")
    private EnderecoCriar endereco;

    public ClienteAtualizar (Cliente cliente){
        this.nome = cliente.getNome();
        this.dataNascimento = cliente.getDataNascimento();
        this.telefone = cliente.getTelefone();
        this.endereco = new EnderecoCriar(
                cliente.getEndereco().getCep(),
                cliente.getEndereco().getComplemento());
    }
}