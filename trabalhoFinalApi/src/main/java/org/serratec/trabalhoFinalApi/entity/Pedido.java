package org.serratec.trabalhoFinalApi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.serratec.trabalhoFinalApi.model.FormasPagamento;
import org.serratec.trabalhoFinalApi.model.PedidoCriar;
import org.serratec.trabalhoFinalApi.model.Status;

import java.time.LocalDateTime;
import java.util.ArrayList;
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

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemPedido> itensPedido = new ArrayList<>();

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

    public Pedido(PedidoCriar pedidoCriar) {
        this.observacoes = pedidoCriar.getObservacoes();
        this.formaDePagamento = pedidoCriar.getFormasDePagamento();
        this.status = pedidoCriar.getStatus();
        this.dataPedido = pedidoCriar.getDataPedido();

    }
}
