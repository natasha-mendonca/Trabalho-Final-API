package org.serratec.trabalhoFinalApi.model.CategoriaDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.serratec.trabalhoFinalApi.entity.Categoria;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaAtualizar {
    private String nome;

    public CategoriaAtualizar(Categoria categoria){
        this.nome = categoria.getNome();
    }
}
