package org.serratec.trabalhoFinalApi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemPedidoSolicitacao {

    private UUID produtoId;

    private Integer quantidade;

    private Double valorVenda;

    private Double desconto;

}
