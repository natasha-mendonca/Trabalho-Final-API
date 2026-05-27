package org.serratec.trabalhoFinalApi.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.serratec.trabalhoFinalApi.entity.Pedido;
import java.time.LocalDate;

@Data
public class PedidoRastreioResponse {

    @Schema(
            description = "Código de rastreamento do pedido",
            example = "BR-A1B2C3D4"
    )
    private String codigoRastreio;

    @Schema(
            description = "Status atual do pedido",
            example = "ENVIADO"
    )
    private String status;

    @Schema(
            description = "Data prevista para entrega",
            example = "2026-06-02"
    )
    private LocalDate previsaoEntrega;

    public PedidoRastreioResponse(Pedido pedido) {
        this.codigoRastreio = pedido.getCodigoRastreio();
        this.status = pedido.getStatus().name();
        this.previsaoEntrega = pedido.getPrevisaoEntrega();
    }
}
