package org.serratec.trabalhoFinalApi.model;

public enum Status {
    CRIADO, //seria o gerado na loja
    AGUARDANDO, //esperando o pagamento
    ANALISE, //analisando fraudes
    PAGO, //confirmaçao
    ENVIADO, //enviado a transportadora
    ENTREGUE,
    CANCELADO
}
