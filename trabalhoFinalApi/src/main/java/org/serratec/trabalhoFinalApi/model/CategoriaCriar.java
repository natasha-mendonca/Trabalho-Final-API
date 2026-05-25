package org.serratec.trabalhoFinalApi.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaCriar {

    @NotBlank
    @Schema(nullable = false, description = "Campo contendo o nome da Categoria", example = "Roupas")
    private String nome;
}
