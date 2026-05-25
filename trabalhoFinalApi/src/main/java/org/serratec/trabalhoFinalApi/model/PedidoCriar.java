package org.serratec.trabalhoFinalApi.model;

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

    @NotEmpty
    private List<ItemPedidoSolicitacao> itens;

//     private Cliente cliente;

    @Max(40)
    private String observacoes;

    @NotNull
    private FormasPagamento formasDePagamento;

 }
