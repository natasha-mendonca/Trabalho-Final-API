package org.serratec.trabalhoFinalApi.model.PedidoDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.serratec.trabalhoFinalApi.entity.Pedido;
import org.serratec.trabalhoFinalApi.model.FormasPagamento;
import org.serratec.trabalhoFinalApi.model.ItemPedidoDto.ItemPedidoBuscar;
import org.serratec.trabalhoFinalApi.model.Status;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoBuscar {

    @Schema(description = "Id do pedido", example = "835c45e4-edf6-463c-bb7d-951cbcfdec46")
    private UUID id;
    private List<ItemPedidoBuscar> itens;

    @Schema(description = "Observações do pedido", example = "Entregar apos as 18h")
    private String observacoes;

    @Schema(description = "Formas de pagamento(Enum)", example = "CREDITO")
    private FormasPagamento formaDePagamento;

    @Schema(description = "Status do pedido", example = "CRIADO")
    private Status status;

    @Schema(description = "Data do pedido", example = "2026-05-27T14:37:46.773Z")
    private LocalDateTime dataPedido;

    @Schema(description = "valor total do pedido", example = "20.0")
    private Double valorTotal;

    @Schema(description = "id para referencia o cliente da compra", example = "3fa85f64-5717-4562-b3fc-2c963f66afa6")
    private UUID clienteId;
//    private Boolean deletado;

    //@ManyToOne
//    private Cliente cliente;


    //    private String formatDataPedido(LocalDateTime dataPedido){
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
//        return dataPedido.format(formatter);
//    }



    public PedidoBuscar(Pedido pedido) {
        this.id = pedido.getId();
        this.observacoes = pedido.getObservacoes();
        this.dataPedido = pedido.getDataPedido();
        this.status = pedido.getStatus();
        this.formaDePagamento = pedido.getFormaDePagamento();

        // Funcionalidade: Pedro: converter a lista de entidades ItemPedido dentro de Pedido para ItemPedidoBuscar(dto)
        if (pedido.getItens() != null) {
            this.itens = pedido.getItens().stream()
                    .map(ItemPedidoBuscar::new)
                    .collect(Collectors.toList());
        }
        //Funcionalidade: Pedro: para cada item do ItemPedidoBuscar pegue o subtotal e some(.sum())
        if (this.itens != null) {
            this.valorTotal = this.itens.stream()
                    .mapToDouble(ItemPedidoBuscar::getSubTotal)
                    .sum();
        }

        this.clienteId = pedido.getCliente().getId();

//        this.deletado = pedido.getDeletado();
    }
}
