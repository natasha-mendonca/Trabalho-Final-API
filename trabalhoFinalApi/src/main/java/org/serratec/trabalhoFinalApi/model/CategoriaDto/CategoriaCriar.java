package org.serratec.trabalhoFinalApi.model.CategoriaDto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaCriar {

    @NotBlank
    private String nome;
}
