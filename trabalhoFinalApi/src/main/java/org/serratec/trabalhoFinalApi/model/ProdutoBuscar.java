package org.serratec.trabalhoFinalApi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.serratec.trabalhoFinalApi.entity.Produto;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoBuscar {
    private UUID id;
    private String nome;
    private String descricao;
    private Double preco;
    private Integer estoque;
    private Boolean ativo;
    private UUID categoriaId;
    private String categoriaNome;

    public ProdutoBuscar(Produto produto){
        this.id =  produto.getId();
        this.nome = produto.getNome();
        this.descricao = produto.getDescricao();
        this.preco = produto.getPreco();
        this.estoque = produto.getEstoque();
        this.ativo = produto.getAtivo();
        this.categoriaId = produto.getCategoria().getId();
        this.categoriaNome = produto.getCategoria().getNome();
    }
}
