package org.serratec.trabalhoFinalApi.model.ProdutoDto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoCriar {

    @NotBlank(message = "O campo nome nao deve estar em branco")
    @Schema(nullable = false, description = "Campo contendo o nome do Produto", example = "Camiseta")
    private String nome;

    @Size(max = 1000, message = "A descricao nao pode ultrapassar 1000 caracteres")
    @Schema(maxLength = 1000, description = "Campo contendo a descrição do Produto")
    private String descricao;

    @NotNull(message = "O campo preco nao deve estar em branco")
    @Min(value = 0, message = "O valor minimo de preco é 0")
    @Schema(nullable = false, description = "Campo contendo o preço do Produto", example = "19.99")
    private Double preco;

    @NotNull(message = "O campo estoque nao deve estar em branco")
    @Min(value = 0, message = "O valor minimo de estoque é 0")
    @Schema(nullable = false, minimum = "0", description = "Campo contendo a quantidade de estoque do Produto", example = "50")
    private Integer estoque;

    @Schema(description = "Campo contendo se o produto está ativo ou não", example = "true")
    private Boolean ativo;

    @NotNull(message = "A categoriaId nao pode ser null")
    @Schema(nullable = false, description = "Campo contendo o ID da categoria que o produto está inserido")
    private UUID categoriaId;
}
