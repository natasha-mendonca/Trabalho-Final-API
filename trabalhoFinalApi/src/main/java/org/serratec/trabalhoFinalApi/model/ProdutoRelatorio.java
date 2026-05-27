package org.serratec.trabalhoFinalApi.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoRelatorio {

    @Schema(description = "ID do produto")
    private UUID id;

    @Schema(description = "Nome do produto", example = "Camiseta")
    private String nome;

    @Schema(description = "Nome do produto", example = "Roupas")
    private String categoriaNome;

    @Schema(description = "Quantidade total de unidades vendidas", example = "200")
    private Integer quantidadeVendida;

    @Schema(description = "Receita total das unidades vendidas", example = "2089.85")
    private Double receitaTotal;
}
