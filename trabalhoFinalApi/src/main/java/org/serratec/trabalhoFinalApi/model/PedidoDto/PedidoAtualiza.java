package org.serratec.trabalhoFinalApi.model.PedidoDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.serratec.trabalhoFinalApi.model.FormasPagamento;
import org.serratec.trabalhoFinalApi.model.Status;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoAtualiza {

    private String observacoes;

    private FormasPagamento formasDePagamento;

    private Status status;

//    private LocalDateTime datePedidoAtualizado;


}