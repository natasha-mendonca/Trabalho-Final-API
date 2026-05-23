package org.serratec.trabalhoFinalApi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.serratec.trabalhoFinalApi.model.FormasPagamento;
import org.serratec.trabalhoFinalApi.model.Status;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
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

    @Enumerated(EnumType.STRING)
    private FormasPagamento formaDePagamento;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "data_pedido")
    private LocalDateTime dataPedido;


    public Pedido(List<ItemPedido> itensPedido, String observacoes, FormasPagamento formaDePagamento, Status status, LocalDateTime dataPedido) {
        this.itensPedido = itensPedido;
        this.observacoes = observacoes;
        this.formaDePagamento = formaDePagamento;
        this.status = status;
        this.dataPedido = dataPedido;
    }
}
