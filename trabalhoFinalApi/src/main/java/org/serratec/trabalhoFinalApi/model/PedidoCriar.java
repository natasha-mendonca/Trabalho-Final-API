package org.serratec.trabalhoFinalApi.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public class PedidoCriar {

//     private Cliente cliente;


    @Max(40)
    private String observacoes;

    @NotNull
    private FormasPagamento formasPagamento;

    @NotNull
    private Status status;

    @NotNull
    private LocalDateTime dataPedido;

 }
