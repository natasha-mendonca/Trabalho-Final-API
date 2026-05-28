package org.serratec.trabalhoFinalApi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;
import org.serratec.trabalhoFinalApi.model.FormasPagamento;
import org.serratec.trabalhoFinalApi.model.PedidoCriar;
import org.serratec.trabalhoFinalApi.model.Status;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Audited
public class Pedido extends Auditoria{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemPedido> itens = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @Column
    private String observacoes;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private FormasPagamento formaDePagamento;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    @Column(name = "data_pedido", nullable = false)
    private LocalDateTime dataPedido;

    @Column(name = "nome_cliente")
    private String nomeCliente;

    @Column(name = "codigo_rastreio", unique = true)
    private String codigoRastreio;

    @Column
    private LocalDate previsaoEntrega;
//
//    @Column
//    private Boolean deletado;

    public Pedido(PedidoCriar pedidoCriar, Cliente cliente) {
        this.observacoes = pedidoCriar.getObservacoes();
        this.formaDePagamento = pedidoCriar.getFormasDePagamento();
        this.status = Status.AGUARDANDO;
        this.dataPedido = LocalDateTime.now();

        this.cliente = cliente;
        this.nomeCliente = cliente.getNome();

    }
}
