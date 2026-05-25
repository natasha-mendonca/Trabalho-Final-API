package org.serratec.trabalhoFinalApi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Check;
import org.serratec.trabalhoFinalApi.model.ItemPedidoSolicitacao;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "item_pedido")
@Check(constraints = "quantidade >= 1")
public class ItemPedido {

//    @EmbeddedId
    //chave composta de identificadores ( chave composta pela junçao das fks )
//    private ItemPedidoId id;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "produto_id", nullable = false)
    private Produto produto;

    @ManyToOne
    @JoinColumn(name = "pedido_id", nullable = false)
    @JsonIgnore
    private Pedido pedido;

    @Column(nullable = false)
    private Integer quantidade;

    @Column(name = "valor_venda", nullable = false)
    private Double valorVenda;

    @Column(nullable = false)
    private Double desconto;

    @Column(name = "sub_total")
    private Double subTotal;

    public ItemPedido(Pedido pedido, Produto produto, ItemPedidoSolicitacao itemPedidoSolicitacao){
        this.pedido = pedido;
        this.produto = produto;
        this.quantidade = itemPedidoSolicitacao.getQuantidade();
        this.valorVenda = produto.getPreco();
        this.desconto = itemPedidoSolicitacao.getDesconto();

        this.subTotal = (valorVenda * quantidade) - desconto;
    }

}