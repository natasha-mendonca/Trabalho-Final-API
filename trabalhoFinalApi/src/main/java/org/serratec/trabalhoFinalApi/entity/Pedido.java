package org.serratec.trabalhoFinalApi.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToMany(mappedBy = "pedido")
    private List<ItemPedido> itensPedido;

//    @ManyToOne
//    private Cliente cliente;

    @Column
    private String observacoes;
//    private FormasPagamento formaDePagamento;

//    private Status status;

    @Column(name = "data_pedido")
    private LocalDateTime dataPedido;

}
