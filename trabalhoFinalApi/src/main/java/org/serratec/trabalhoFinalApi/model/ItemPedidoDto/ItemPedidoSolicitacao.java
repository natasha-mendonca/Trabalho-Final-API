package org.serratec.trabalhoFinalApi.model.ItemPedidoDto;

import io.swagger.v3.oas.annotations.media.Schema;
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

    @Schema(example = "1", nullable = false, description = "Campo produtoId")
    @NotNull(message = "O identificador do produto nao pode ser null")
    private UUID produtoId;

    @Schema(example = "3", nullable = false, description = "Campo de quantidade", minimum = "1")
    @NotNull(message = "Quantidade nao pode ser null")
    @Min(value = 1, message = "A quantidade do produto precisa ser igual ou maior que 1")
    private Integer quantidade;
}
