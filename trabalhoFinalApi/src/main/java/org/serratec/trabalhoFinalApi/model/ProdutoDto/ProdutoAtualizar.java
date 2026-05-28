package org.serratec.trabalhoFinalApi.model.ProdutoDto;

import io.swagger.v3.oas.annotations.media.Schema;
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

    @Schema( description = "Campo contendo o nome do Produto", example = "PendureJogador01")
    private String nome;

    @Size(max = 1000)
    @Schema(maxLength = 1000, description = "Campo contendo a descrição do Produto")
    private String descricao;

    @Min(0)
    @Schema(description = "Campo contendo o preço do Produto", example = "19.99")
    private Double preco;

    @Min(0)
    @Schema(minimum = "0", description = "Campo contendo a quantidade de estoque do Produto", example = "50")
    private Integer estoque;

    @Schema(description = "Campo contendo se o produto está ativo ou não", example = "true")
    private Boolean ativo;

    @Schema(nullable = false, description = "Campo contendo o ID da categoria que o produto está inserido")
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
