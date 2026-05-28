package org.serratec.trabalhoFinalApi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.serratec.trabalhoFinalApi.exception.generalista.MensagemErroSwagger;
import org.serratec.trabalhoFinalApi.model.PedidoBuscar;
import org.serratec.trabalhoFinalApi.model.RelatorioResponse;
import org.serratec.trabalhoFinalApi.service.FechamentoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/financeiro/fechamento")
@Tag(name = "Balanceamento", description = "Conferir o faturamento de cada periodo")
public class FechamentoController {

    private FechamentoService fechamentoService;

    public FechamentoController(FechamentoService fechamentoService) {
        this.fechamentoService = fechamentoService;
    }

    @Operation(summary = "Buscar faturamento do pedido", description = "Busca do faturamento mediante a um padrao de busca: hoje/semana/ano")
    @ApiResponses(value = {@ApiResponse(description = "Busca do faturamento do pedido retornado", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = RelatorioResponse.class))),
            @ApiResponse(description = "Dados informados inválidos", responseCode = "400", content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = MensagemErroSwagger.class))),
            @ApiResponse(description = "Dados não encontrados", responseCode = "404", content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = MensagemErroSwagger.class))),
            @ApiResponse(description = "Erro inteiro no servidor", responseCode = "500", content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation =  MensagemErroSwagger.class)))})
    @GetMapping("/{tipo}")
    public ResponseEntity<Map<String, Object>> obterFechamento(@Parameter(description = "Tipo: dia/semana/ano", required = true) @PathVariable String tipo) {
        Double valorTotal = fechamentoService.calcularFaturamento(tipo);

        Map<String, Object> resposta = new LinkedHashMap<>();
        resposta.put("status", "sucesso");
        resposta.put("tipo_relatorio", tipo.toUpperCase());
        resposta.put("valor_total", valorTotal);

        return ResponseEntity.ok(resposta);
    }
}