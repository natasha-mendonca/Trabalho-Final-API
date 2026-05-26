//package org.serratec.trabalhoFinalApi.service;
//
//import org.serratec.trabalhoFinalApi.entity.EnderecoNatasha;
//import org.serratec.trabalhoFinalApi.exception.DadoInvalidoNatasha;
//import org.serratec.trabalhoFinalApi.model.EnderecoCriarNatasha;
//import org.serratec.trabalhoFinalApi.model.ViaCepResponseNatasha;
//import org.serratec.trabalhoFinalApi.repository.EnderecoRepository;
//import org.serratec.trabalhoFinalApi.repository.EnderecoRepositoryNatasha;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.client.HttpClientErrorException;
//import org.springframework.web.client.RestClient;
//
//import static org.springframework.http.HttpStatus.BAD_REQUEST;
//
//public class EnderecoServiceNatasha {
//
//    private final EnderecoRepository enderecoRepository;
//    private final RestClient restClient;
//
//    public EnderecoServiceNatasha(EnderecoRepository enderecoRepository) {
//        this.enderecoRepository = enderecoRepository;
//        this.restClient = RestClient.builder().baseUrl("https://viacep.com.br").build();
//    }
//
//    public EnderecoNatasha inserir(EnderecoCriarNatasha enderecoCriar) {
//        try {
//            ResponseEntity<ViaCepResponseNatasha> viaCepConsulta = this.restClient
//                    .get()
//                    .uri("/ws/" + enderecoCriar.getCep() + "/json")
//                    .accept(MediaType.APPLICATION_JSON)
//                    .retrieve()
//                    .toEntity(ViaCepResponseNatasha.class);
//
//            EnderecoNatasha endereco = new EnderecoNatasha(enderecoCriar, viaCepConsulta.getBody());
//            this.enderecoRepository.save(endereco);
//            return endereco;
//        } catch (HttpClientErrorException ex) {
//            if (ex.getStatusCode() == BAD_REQUEST) {
//                throw new DadoInvalidoNatasha("O cep informado é invalido");
//            }
//            throw ex;
//        }
//    }
//}
