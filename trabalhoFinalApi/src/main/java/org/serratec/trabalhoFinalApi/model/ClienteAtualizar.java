package org.serratec.trabalhoFinalApi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.serratec.trabalhoFinalApi.entity.Cliente;
import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteAtualizar {

    private UUID id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private EnderecoCriar endereco;

    public ClienteAtualizar (Cliente cliente){
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.cpf = cliente.getCpf();
        this.email = cliente.getEmail();
        this.telefone = cliente.getTelefone();
        this.endereco = new EnderecoCriar(
                cliente.getEndereco().getCep(),
                cliente.getEndereco().getComplemento());
    }
}