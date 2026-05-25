package org.serratec.trabalhoFinalApi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.serratec.trabalhoFinalApi.model.EnderecoCriar;
import org.serratec.trabalhoFinalApi.model.ViaCepResponse;
import java.util.UUID;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String logradouro;

    @Column(nullable = false)
    private String cep;

    @Column(nullable = false)
    private String complemento;

    @Column(nullable = false)
    private String bairro;

    @Column(nullable = false)
    private String cidade;

    @Column(nullable = false)
    private String estado;

    public Endereco(EnderecoCriar enderecoCriar, ViaCepResponse viaCepResponse) {
        this.logradouro = viaCepResponse.logradouro();
        this.bairro = viaCepResponse.bairro();
        this.cidade = viaCepResponse.cidade();
        this.estado = viaCepResponse.estado();
        this.cep = enderecoCriar.getCep();
        this.complemento = enderecoCriar.getCep();
    }
}
