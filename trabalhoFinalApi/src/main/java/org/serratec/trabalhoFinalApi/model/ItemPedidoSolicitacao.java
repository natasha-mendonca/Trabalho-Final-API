package org.serratec.trabalhoFinalApi.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemPedidoSolicitacao {

    @NotNull(message = "O identificador do produto nao pode ser null")
    private Long produtoId;

    @NotNull(message = "Quantidade nao pode ser null")
    @Min(value = 1, message = "A quantidade do produto precisa ser igual ou maior que 1")
    private Integer quantidade;

    @NotNull(message = "Valor de venda nao pode ser null")
    @Min(value = 1 , message = "O valor do venda precisa ser igual ou maior que 1")
    private Double valorVenda;

    @NotNull(message = "Desconto nao pode ser null")
    @Min(value = 0, message = "O valor do desconto precisa ser maior que 0")
    private Double desconto;

}
