package org.serratec.trabalhoFinalApi.model.ClienteDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.serratec.trabalhoFinalApi.entity.Cliente;
import org.serratec.trabalhoFinalApi.model.EnderecoDto.EnderecoBuscar;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteBuscar {

    @Schema(description = "Id do cliente", requiredMode = Schema.RequiredMode.REQUIRED)
    private UUID id;

    @Schema(description = "Nome completo do cliente", requiredMode = Schema.RequiredMode.REQUIRED)
    private String nome;

    @Schema(description = "CPF do cliente", requiredMode = Schema.RequiredMode.REQUIRED)
    private String cpf;

    @Schema(description = "E-mail do cliente", requiredMode = Schema.RequiredMode.REQUIRED)
    private String email;

    @Schema(description = "Telefone do cliente", requiredMode = Schema.RequiredMode.REQUIRED)
    private String telefone;

    @Schema(description = "Endereço do cliente", requiredMode = Schema.RequiredMode.REQUIRED)
    private EnderecoBuscar endereco;

    public ClienteBuscar (Cliente cliente){
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.cpf = cliente.getCpf();
        this.email = cliente.getEmail();
        this.telefone = cliente.getTelefone();
        this.endereco = new EnderecoBuscar(cliente.getEndereco());
    }
}