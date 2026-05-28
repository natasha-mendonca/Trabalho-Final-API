package org.serratec.trabalhoFinalApi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;
import org.serratec.trabalhoFinalApi.model.ProdutoDto.ProdutoCriar;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Audited
public class Produto extends Auditoria{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String nome;

    @Column(length = 1000)
    private String descricao;

    @Column(nullable = false)
    private Double preco;

    @Column(nullable = false)
    private Integer estoque;

    @Column
    private Boolean ativo;

    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = false)
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    private Categoria categoria;

    public Produto(ProdutoCriar produto, Categoria categoria){
        this.nome = produto.getNome();
        this.descricao = produto.getDescricao();
        this.preco = produto.getPreco();
        this.estoque = produto.getEstoque();
        this.ativo = produto.getAtivo();
        this.categoria = categoria;

    }
}
