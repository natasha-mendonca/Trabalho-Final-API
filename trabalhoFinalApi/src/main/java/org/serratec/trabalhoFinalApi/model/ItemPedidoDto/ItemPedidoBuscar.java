package org.serratec.trabalhoFinalApi.model.ItemPedidoDto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.serratec.trabalhoFinalApi.entity.ItemPedido;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemPedidoBuscar {

    private Long id;
    private String nomeProduto;
    private Integer quantidade;
    private Double valorVenda;
    private Double desconto;
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