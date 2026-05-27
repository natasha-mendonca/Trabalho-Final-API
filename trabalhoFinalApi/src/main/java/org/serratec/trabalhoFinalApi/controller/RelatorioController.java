package org.serratec.trabalhoFinalApi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.serratec.trabalhoFinalApi.exception.generalista.MensagemErroSwagger;
import org.serratec.trabalhoFinalApi.model.ProdutoRelatorio;
import org.serratec.trabalhoFinalApi.service.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Tag(name = "Relatório: Produtos mais vendidos", description = "Pacote contendo as requisições envolvendo relatório de produtos mais vendidos")
@RequestMapping("/mais-vendidos")
@RestController
@AllArgsConstructor
public class RelatorioController {
    private ProdutoService produtoService;

    @GetMapping
    @Operation(summary = "Relatório de produtos mais vendidos", description = "Retorna lista com os produtos mais vendidos em ordem.")
    @ApiResponses(value = {
            @ApiResponse (description = "Relatatório gerado com sucesso", responseCode = "200", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ProdutoRelatorio.class))) ),
            @ApiResponse (description = "Dados não encontrados", responseCode = "404", content = @Content(mediaType = "application/json",schema = @Schema(implementation = MensagemErroSwagger.class))),
            @ApiResponse (description = "Erro interno no servidor", responseCode = "500", content = @Content(mediaType = "application/json", schema = @Schema(implementation = MensagemErroSwagger.class)))
    })
    public ResponseEntity<List<ProdutoRelatorio>> buscarProdutosMaisVendidos(){
        return ResponseEntity.ok(produtoService.buscarProdutosMaisVendidos());
    }
}
