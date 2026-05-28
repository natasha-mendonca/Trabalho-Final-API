package org.serratec.trabalhoFinalApi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;
import org.serratec.trabalhoFinalApi.model.ClienteDto.ClienteCriar;

import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Audited
public class Cliente extends Auditoria{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column
    private String nome;

    @Column(unique = true, length = 11)
    private String cpf;

    @Column
    private LocalDate dataNascimento;

    @Column(unique = true, length = 50)
    private String email;

    @Column(length = 13)
    private String telefone;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id")
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    private Endereco endereco;

    public Cliente(ClienteCriar cliente, Endereco endereco) {
        this.nome = cliente.getNome();
        this.cpf = cliente.getCpf();
        this.dataNascimento = cliente.getDataNascimento();
        this.email = cliente.getEmail();
        this.telefone = cliente.getTelefone();
        this.endereco = endereco;
        this.dataNascimento = cliente.getDataNascimento();
    }
}
