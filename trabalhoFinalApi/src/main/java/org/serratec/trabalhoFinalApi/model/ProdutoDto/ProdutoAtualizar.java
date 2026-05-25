package org.serratec.trabalhoFinalApi.model.ProdutoDto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.serratec.trabalhoFinalApi.entity.Produto;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoAtualizar {
    private String nome;

    @Size(max = 1000)
    private String descricao;

    private Double preco;

    @Min(0)
    private Integer estoque;

    private Boolean ativo;

    private UUID categoriaId;

    public ProdutoAtualizar(Produto produto){
        this.nome = produto.getNome();
        this.descricao = produto.getDescricao();
        this.preco = produto.getPreco();
        this.estoque = produto.getEstoque();
        this.ativo = produto.getAtivo();
        this.categoriaId = produto.getCategoria().getId();
    }
}
