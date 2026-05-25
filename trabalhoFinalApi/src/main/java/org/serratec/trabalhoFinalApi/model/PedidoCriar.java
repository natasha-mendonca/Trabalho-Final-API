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

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoCriar {

    @Valid
    @NotEmpty(message = "os itens do pedido precisam ser informados")
    private List<ItemPedidoSolicitacao> itens;

//     private Cliente cliente;

    @Max(40)
    private String observacoes;

    @NotNull(message = "A forma de pagamento nao pode ser null")
    private FormasPagamento formasDePagamento;

 }
