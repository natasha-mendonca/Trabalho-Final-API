package org.serratec.trabalhoFinalApi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.serratec.trabalhoFinalApi.exception.generalista.MensagemErroSwagger;
import org.serratec.trabalhoFinalApi.model.*;
import org.serratec.trabalhoFinalApi.service.CategoriaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "Categoria", description = "Pacote contendo as requisições envolvendo categorias")
@AllArgsConstructor
@RestController
@RequestMapping("/categoria")
public class CategoriaController {
    private CategoriaService categoriaService;

    @Operation(summary = "Cadastrar categoria", description = "Cadastra uma nova categoria no sistema")
    @ApiResponses(value = {
            @ApiResponse (description = "Categoria criada com sucesso", responseCode = "201", content = @Content(mediaType = "application/json", schema = @Schema(implementation = MensagemSucesso.class))),
            @ApiResponse (description = "Dados informados inválidos", responseCode = "400", content = @Content(schema = @Schema(implementation = MensagemErroSwagger.class), mediaType = "application/json")),
            @ApiResponse (description = "Erro interno no servidor", responseCode = "500", content = @Content(schema = @Schema(implementation = MensagemErroSwagger.class), mediaType = "application/json"))
    })
    @PostMapping
    public ResponseEntity<MensagemSucesso> cadastrarCategoria(@RequestBody @Valid CategoriaCriar categoriaCriar){
        categoriaService.cadastrarCategoria(categoriaCriar);
        return ResponseEntity.status(HttpStatus.CREATED).body(new MensagemSucesso("Categoria criada com sucesso!"));
    }

    @Operation(summary = "Buscar categorias", description = "Busca as categorias por: ID ou nome")
    @ApiResponses(value = {
            @ApiResponse(description = "Categorias encontradas com sucesso", responseCode = "200", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = CategoriaBuscar.class)))),
            @ApiResponse (description = "Dados informados inválidos", responseCode = "400", content = @Content(mediaType = "application/json", schema = @Schema(implementation = MensagemErroSwagger.class))),
            @ApiResponse (description = "Dados não encontrados", responseCode = "404", content = @Content(mediaType = "application/json", schema = @Schema(implementation = MensagemErroSwagger.class))),
            @ApiResponse (description = "Erro interno no servidor", responseCode = "500", content = @Content(mediaType = "application/json", schema = @Schema(implementation = MensagemErroSwagger.class)))
    })
    @GetMapping
    public ResponseEntity<List<CategoriaBuscar>> buscarCategoria(@RequestParam(required = false) UUID id, @RequestParam(required = false) String nome){
        List<CategoriaBuscar> categorias = categoriaService.buscarCategoria(id, nome);
        return ResponseEntity.status(HttpStatus.OK).body(categorias);
    }


    @Operation(summary = "Atualizar categoria", description = "Atualiza os dados de uma categoria existente por ID")
    @ApiResponses(value = {
            @ApiResponse (description = "Categoria atualizada com sucesso", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = MensagemSucesso.class))),
            @ApiResponse (description = "Dados informados inválidos", responseCode = "400", content = @Content(schema = @Schema(implementation = MensagemErroSwagger.class), mediaType = "application/json")),
            @ApiResponse (description = "Dados não encontrados", responseCode = "404", content = @Content(schema = @Schema(implementation = MensagemErroSwagger.class), mediaType = "application/json")),
            @ApiResponse (description = "Erro interno no servidor", responseCode = "500", content = @Content(schema = @Schema(implementation = MensagemErroSwagger.class), mediaType = "application/json"))
    })
    @PutMapping("/{id}")
    public ResponseEntity<MensagemSucesso> atualizarCategoria(@PathVariable UUID id, @RequestBody @Valid CategoriaAtualizar categoria){
        categoriaService.atualizarCategoria(id, categoria);
        return ResponseEntity.status(HttpStatus.OK).body(new MensagemSucesso("Categoria atualizada com sucesso!"));
    }

    @Operation(summary = "Deletar categoria", description = "Deleta a categoria por ID")
    @ApiResponses(value = {
            @ApiResponse (description = "Categoria deletada com sucesso", responseCode = "204"),
            @ApiResponse (description = "Dados informados inválidos", responseCode = "400", content = @Content(mediaType = "application/json", schema = @Schema(implementation = MensagemErroSwagger.class))),
            @ApiResponse (description = "Dados não encontrados", responseCode = "404", content = @Content(mediaType = "application/json", schema = @Schema(implementation = MensagemErroSwagger.class))),
            @ApiResponse (description = "Erro interno no servidor", responseCode = "500", content = @Content(mediaType = "application/json", schema = @Schema(implementation = MensagemErroSwagger.class)))
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCategoria(@PathVariable UUID id){
        categoriaService.deletarCategoria(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
