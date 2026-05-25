package org.serratec.trabalhoFinalApi.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.serratec.trabalhoFinalApi.entity.Categoria;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaAtualizar {

    @Schema( description = "Campo contendo o nome da Categoria", example = "Roupas")
    private String nome;

    public CategoriaAtualizar(Categoria categoria){
        this.nome = categoria.getNome();
    }
}
