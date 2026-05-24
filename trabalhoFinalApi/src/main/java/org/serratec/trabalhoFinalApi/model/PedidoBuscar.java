package org.serratec.trabalhoFinalApi.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.serratec.trabalhoFinalApi.entity.Pedido;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoBuscar {

    private UUID id;
    private List<ItemPedidoBuscar> itens;
    private String observacoes;
    private FormasPagamento formaDePagamento;
    private Status status;
    private LocalDateTime dataPedido;
    private Double valorTotal;

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

        // Funcionalidade: Converter a lista de entidades ItemPedido dentro de Pedido para ItemPedidoBuscar(dto)
        if (pedido.getItens() != null) {
            this.itens = pedido.getItens().stream()
                    .map(ItemPedidoBuscar::new)
                    .collect(Collectors.toList());
        }
        //Funcionalidade: para cada item do ItemPedidoBuscar pegue o subtotal e some(.sum())
        if (this.itens != null) {
            this.valorTotal = this.itens.stream()
                    .mapToDouble(ItemPedidoBuscar::getSubTotal)
                    .sum();
        }
    }
}
