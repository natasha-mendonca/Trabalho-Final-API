package org.serratec.trabalhoFinalApi.model.ProdutoDto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoCriar {

    @NotBlank
    private String nome;

    @Size(max = 1000)
    private String descricao;

    @NotNull
    private Double preco;

    @NotNull
    @Min(0)
    private Integer estoque;

    private Boolean ativo;

    @NotNull
    private UUID categoriaId;
}
