package org.serratec.trabalhoFinalApi.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoCriar {

    @Valid
    @NotEmpty(message = "os itens do pedido precisam ser informados")
    private List<ItemPedidoSolicitacao> itens;

    @Schema(example = "2abbcd9b-cd9a-4272-9863-8321d2a593ec", nullable = false, description = "Id do cliente")
    @NotNull(message = "Para criar um pedido, é necessario que o cliente seja inserido tambem")
    private UUID clienteId;

    @Schema(example = "pedido necessita de urgencia", description = "Campo de observaçoes(opcional)", maxLength = 40)
    @Size(max = 40)
    private String observacoes;

    @Schema(example = "PIX", nullable = false, description = "Campo com a forma de pegamento")
    @NotNull(message = "A forma de pagamento nao pode ser null")
    private FormasPagamento formasDePagamento;
 }
