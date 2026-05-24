package org.serratec.trabalhoFinalApi.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.serratec.trabalhoFinalApi.entity.ItemPedido;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemPedidoBuscar {

    private Long id;
    private String nomeProduto; // Aqui está o segredo: apenas o nome em vez do objeto inteiro
    private Integer quantidade;
    private Double valorVenda;
    private Double desconto;
    private Double subTotal;

    // Construtor para converter a Entidade no DTO
    public ItemPedidoBuscar(ItemPedido itemPedido) {
        this.id = itemPedido.getId();
        this.quantidade = itemPedido.getQuantidade();
        this.valorVenda = itemPedido.getValorVenda();
        this.desconto = itemPedido.getDesconto();
        this.subTotal = itemPedido.getSubTotal();

        // Evita NullPointerException caso o produto venha nulo por algum motivo
        if (itemPedido.getProduto() != null) {
            this.nomeProduto = itemPedido.getProduto().getNome();
        }
    }
}