package org.serratec.trabalhoFinalApi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.serratec.trabalhoFinalApi.model.CategoriaCriar;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String nome;

    @OneToMany( mappedBy = "categoria")
    @JsonIgnore
    private List<Produto> produtos;

    public Categoria(CategoriaCriar categoria){
        this.nome = categoria.getNome();
    }
}
