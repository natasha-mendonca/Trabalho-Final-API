package org.serratec.trabalhoFinalApi.model;

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

    @NotBlank
    @Schema(nullable = false, description = "Campo contendo o nome do Produto", example = "Camiseta")
    private String nome;

    @Size(max = 1000)
    @Schema(maxLength = 1000, description = "Campo contendo a descrição do Produto")
    private String descricao;

    @NotNull
    @Schema(nullable = false, description = "Campo contendo o preço do Produto", example = "19.99")
    private Double preco;

    @NotNull
    @Min(0)
    @Schema(nullable = false, minimum = "0", description = "Campo contendo a quantidade de estoque do Produto", example = "50")
    private Integer estoque;

    @Schema(description = "Campo contendo se o produto está ativo ou não", example = "true")
    private Boolean ativo;

    @NotNull
    @Schema(nullable = false, description = "Campo contendo o ID da categoria que o produto está inserido")
    private UUID categoriaId;
}
