package org.serratec.trabalhoFinalApi.model;

public record ViaCepResponse(String cep, String logradouro, String bairro, String cidade, String estado, String uf) {
}
