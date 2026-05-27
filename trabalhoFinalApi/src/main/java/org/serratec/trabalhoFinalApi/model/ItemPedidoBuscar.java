package org.serratec.trabalhoFinalApi.model;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.serratec.trabalhoFinalApi.entity.ItemPedido;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemPedidoBuscar {

    @Schema(description = "id", example = "1")
    private Long id;

    @Schema(description = "Nome do produto", example = "ChaveiroMagico")
    private String nomeProduto;

    @Schema(description = "Quantidade requisitada", example = "3")
    private Integer quantidade;

    @Schema(description = "Valor da venda", example = "20.0")
    private Double valorVenda;

    @Schema(description = "Valor de desconto", example = "0.0")
    private Double desconto;

    @Schema(description = "valor subtotal do item, baseado no desconto e na quantidade", example = "20.0")
    private Double subTotal;

    public ItemPedidoBuscar(ItemPedido itemPedido) {
        this.id = itemPedido.getId();
        this.quantidade = itemPedido.getQuantidade();
        this.valorVenda = itemPedido.getValorVenda();
        this.desconto = itemPedido.getDesconto();
        this.subTotal = itemPedido.getSubTotal();

        // Verificacao caso o produto venha nulo por algum motivo
        if (itemPedido.getProduto() != null) {
            this.nomeProduto = itemPedido.getProduto().getNome();
        }
    }
}