package org.serratec.trabalhoFinalApi.model.ProdutoDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.serratec.trabalhoFinalApi.entity.Produto;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoBuscar {

    @Schema(requiredMode = Schema.RequiredMode.REQUIRED)
    private UUID id;

    @Schema(requiredMode = Schema.RequiredMode.REQUIRED)
    private String nome;

    @Schema(requiredMode = Schema.RequiredMode.REQUIRED)
    private String descricao;

    @Schema(requiredMode = Schema.RequiredMode.REQUIRED)
    private Double preco;

    @Schema(requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer estoque;

    @Schema(requiredMode = Schema.RequiredMode.REQUIRED)
    private Boolean ativo;

    @Schema(requiredMode = Schema.RequiredMode.REQUIRED)
    private UUID categoriaId;

    @Schema(requiredMode = Schema.RequiredMode.REQUIRED)
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
