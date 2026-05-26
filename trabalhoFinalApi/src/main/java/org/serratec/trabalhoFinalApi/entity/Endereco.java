package org.serratec.trabalhoFinalApi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;
import org.serratec.trabalhoFinalApi.model.EnderecoCriar;
import org.serratec.trabalhoFinalApi.model.ViaCepResponse;
import java.util.UUID;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Audited
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
    private String localidade;

    @Column(nullable = false)
    private String uf;

    public Endereco(EnderecoCriar enderecoCriar, ViaCepResponse viaCepResponse) {
        this.logradouro = viaCepResponse.logradouro();
        this.bairro = viaCepResponse.bairro();
        this.localidade = viaCepResponse.localidade();
        this.uf = viaCepResponse.uf();
        this.cep = enderecoCriar.getCep();
        this.complemento = enderecoCriar.getComplemento();
    }
}
