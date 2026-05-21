package org.serratec.trabalhoFinalApi.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "item_pedido")
public class ItemPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

//    @ManyToOne
//    @JoinColumn(name = "produto_id")
//    private Produto produto;

    @Column
    private Integer quantidade;

    @Column(name = "valor_venda")
    private Float valorVenda;

    @Column
    private Float desconto;


}
