package org.serratec.trabalhoFinalApi.model.PedidoDto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.serratec.trabalhoFinalApi.model.FormasPagamento;
import org.serratec.trabalhoFinalApi.model.Status;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoAtualiza {

    @Size(max = 100)
    @Schema(description = "Campo contendo observacoes", example = "Pedido entregue ao destinatário", maxLength = 100)
    private String observacoes;

    @Schema(description = "Campo contendo a forma de pagamento", nullable = false, example = "PIX")
    private FormasPagamento formasDePagamento;

    @Schema(description = "Campo contendo o status", nullable = false, example = "ENTREGUE")
    private Status status;

}