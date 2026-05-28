package org.serratec.trabalhoFinalApi.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.serratec.trabalhoFinalApi.entity.Cliente;

import java.time.LocalDate;
import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteAtualizar {

    @Schema(description = "Id do cliente")
    private UUID id;

    @Schema(description = "Nome completo do cliente")
    private String nome;


    @Schema(description = "Data de nascimento do cliente")
    private LocalDate dataNascimento;

    @Schema(description = "E-mail do cliente")
    private String email;

    @Schema(description = "Telefone do cliente")
    private String telefone;

    @Schema(description = "Endereço do cliente")
    private EnderecoCriar endereco;

    public ClienteAtualizar (Cliente cliente){
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.dataNascimento = cliente.getDataNascimento();
        this.email = cliente.getEmail();
        this.telefone = cliente.getTelefone();
        this.endereco = new EnderecoCriar(
                cliente.getEndereco().getCep(),
                cliente.getEndereco().getComplemento());
    }
}