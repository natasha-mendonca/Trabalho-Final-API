package org.serratec.trabalhoFinalApi.entity;

import jakarta.persistence.*;
import org.serratec.trabalhoFinalApi.model.ItemPedidoSolicitacao;

@Entity
@Table(name = "item_pedido")
public class ItemPedido {

//    @EmbeddedId
    //chave composta de identificadores ( chave composta pela junçao das fks )
//    private ItemPedidoId id;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    @Column
    private Integer quantidade;

    @Column(name = "valor_venda")
    private Double valorVenda;

    @Column
    private Double desconto;

    public ItemPedido(Pedido pedido, Produto produto, ItemPedidoSolicitacao itemPedidoSolicitacao){
        this.pedido = pedido;
        this.produto = produto;
        this.quantidade = itemPedidoSolicitacao.getQuantidade();
        this.valorVenda = produto.getPreco();
        this.desconto = itemPedidoSolicitacao.getDesconto();
    }

}