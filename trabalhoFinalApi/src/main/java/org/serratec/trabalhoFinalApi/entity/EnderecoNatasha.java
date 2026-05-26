package org.serratec.trabalhoFinalApi.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.serratec.trabalhoFinalApi.model.EnderecoCriarNatasha;
import org.serratec.trabalhoFinalApi.model.ViaCepResponseNatasha;

import java.util.UUID;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoNatasha {

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

        public EnderecoNatasha(EnderecoCriarNatasha endereco, ViaCepResponseNatasha viaCepConsulta) {
            this.cep = endereco.getCep();
            this.complemento = endereco.getComplemento();
            this.estado = viaCepConsulta.estado();
            this.bairro = viaCepConsulta.bairro();
            this.cidade = viaCepConsulta.localidade();
            this.logradouro = viaCepConsulta.logradouro();
        }
}
