package org.serratec.trabalhoFinalApi.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RelatorioResponse {

    @Schema(example = "sucesso", requiredMode = Schema.RequiredMode.REQUIRED)
    private String sucesso;

    @Schema(example = "HOJE", requiredMode = Schema.RequiredMode.REQUIRED)
    private String tipo_relatorio;

    @Schema(example = "600.0", requiredMode = Schema.RequiredMode.REQUIRED)
    private Double valor_total;
}
