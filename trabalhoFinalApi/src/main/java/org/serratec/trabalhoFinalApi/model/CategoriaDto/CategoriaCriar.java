package org.serratec.trabalhoFinalApi.model.CategoriaDto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaCriar {

    @NotBlank(message = "Nome da categoria nao deve estar em branco")
    @Schema(nullable = false, description = "Campo contendo o nome da Categoria", example = "Metal")
    private String nome;
}
