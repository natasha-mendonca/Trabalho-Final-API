package org.serratec.trabalhoFinalApi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoAtualiza {

    private String observacoes;

    private FormasPagamento formasDePagamento;

    private Status status;

//    private LocalDateTime datePedidoAtualizado;


}