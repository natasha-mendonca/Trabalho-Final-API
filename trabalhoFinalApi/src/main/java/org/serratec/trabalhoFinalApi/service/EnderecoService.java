package org.serratec.trabalhoFinalApi.service;

import org.serratec.trabalhoFinalApi.entity.Endereco;
import org.serratec.trabalhoFinalApi.model.EnderecoCriar;
import org.serratec.trabalhoFinalApi.model.ViaCepResponse;
import org.serratec.trabalhoFinalApi.repository.EnderecoRepository;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class EnderecoService {

    private EnderecoRepository enderecoRepository;
    private final RestClient restClient;

    public EnderecoService (EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
        this.restClient = RestClient.builder().baseUrl("https://viacep.com.br").build();
    }

    public Endereco adicionarEndereco(EnderecoCriar enderecoCriar) {
        try{
            ResponseEntity<ViaCepResponse> consultaViaCep = this.restClient
                    .get()
                    .uri("/ws/" + enderecoCriar.getCep() + "/json")
                    .accept(MediaType.APPLICATION_JSON)
                    .retrieve()
                    .toEntity(ViaCepResponse.class);

            Endereco endereco = new Endereco(enderecoCriar, consultaViaCep.getBody());
            this.enderecoRepository.save(endereco);
            return endereco;
        }
        catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
