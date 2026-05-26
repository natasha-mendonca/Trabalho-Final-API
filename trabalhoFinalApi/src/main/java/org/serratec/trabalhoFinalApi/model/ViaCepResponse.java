package org.serratec.trabalhoFinalApi.model;

public record ViaCepResponse(String cep, String logradouro, String bairro, String localidade, String estado, String uf, Boolean erro) {
}
