package org.serratec.trabalhoFinalApi.model.ItemPedidoDto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemPedidoSolicitacao {

    @Schema(example = "1", nullable = false, description = "Campo produtoId")
    @NotNull(message = "O identificador do produto nao pode ser null")
    private Long produtoId;

    @Schema(example = "3", nullable = false, description = "Campo de quantidade", minimum = "1")
    @NotNull(message = "Quantidade nao pode ser null")
    @Min(value = 1, message = "A quantidade do produto precisa ser igual ou maior que 1")
    private Integer quantidade;

    @Schema(example = "2000.20", nullable = false, description = "Campo com o valor venda", minimum = "1")
    @NotNull(message = "Valor de venda nao pode ser null")
    @Min(value = 1 , message = "O valor do venda precisa ser igual ou maior que 1")
    private Double valorVenda;

    @Schema(example = "200", nullable = false, description = "Campo com o desconto", minimum = "0")
    @NotNull(message = "Desconto nao pode ser null")
    @Min(value = 0, message = "O valor do desconto precisa ser maior que 0")
    private Double desconto;

}
