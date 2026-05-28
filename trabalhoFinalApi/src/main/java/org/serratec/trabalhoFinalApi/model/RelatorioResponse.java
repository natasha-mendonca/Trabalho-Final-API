package org.serratec.trabalhoFinalApi.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RelatorioResponse {

    @Schema(example = "sucesso")
    private String sucesso;

    @Schema(example = "HOJE")
    private String tipo_relatorio;

    @Schema(example = "600.0")
    private Double valor_total;
}
