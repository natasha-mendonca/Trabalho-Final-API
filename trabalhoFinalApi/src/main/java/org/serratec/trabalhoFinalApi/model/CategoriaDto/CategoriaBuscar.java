package org.serratec.trabalhoFinalApi.model.CategoriaDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.serratec.trabalhoFinalApi.entity.Categoria;
import org.serratec.trabalhoFinalApi.entity.Produto;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaBuscar {
    @Schema(requiredMode = Schema.RequiredMode.REQUIRED)
    private UUID id;
    @Schema(requiredMode = Schema.RequiredMode.REQUIRED)
    private String nome;
    @Schema(requiredMode = Schema.RequiredMode.REQUIRED)
    private List<String> produtos;

    public CategoriaBuscar(Categoria categoria){
        this.id  = categoria.getId();
        this.nome = categoria.getNome();
        if (categoria.getProdutos() != null && !categoria.getProdutos().isEmpty()) {
            this.produtos = categoria.getProdutos()
                    .stream()
                    .map(Produto::getNome)
                    .toList();
        }
    }

}
