package org.serratec.trabalhoFinalApi.exception.generalista;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MensagemErroSwagger {

    @Schema(description = "Data e hora do erro", example = "2026-05-27T11:45:21.1500176", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime timestamp;

    @Schema(description = "Status HTTP", example = "Integer", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer status;

    @Schema(description = "Mensagem detalhada do erro", example = "String", requiredMode = Schema.RequiredMode.REQUIRED)
    private String mensagem;
}
