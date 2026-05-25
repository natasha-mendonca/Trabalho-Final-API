package org.serratec.trabalhoFinalApi.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoCriar {

    @Valid
    @NotEmpty(message = "os itens do pedido precisam ser informados")
    private List<ItemPedidoSolicitacao> itens;

    @NotNull(message = "Para criar um pedido, é necessario que o cliente seja inserido tambem")
    private UUID clienteId;

    @Max(40)
    private String observacoes;

    @NotNull(message = "A forma de pagamento nao pode ser null")
    private FormasPagamento formasDePagamento;

 }
