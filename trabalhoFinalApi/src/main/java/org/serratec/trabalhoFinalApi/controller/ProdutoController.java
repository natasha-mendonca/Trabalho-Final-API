package org.serratec.trabalhoFinalApi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.serratec.trabalhoFinalApi.exception.generalista.MensagemErroSwagger;
import org.serratec.trabalhoFinalApi.model.MensagemSucesso;
import org.serratec.trabalhoFinalApi.model.ProdutoAtualizar;
import org.serratec.trabalhoFinalApi.model.ProdutoBuscar;
import org.serratec.trabalhoFinalApi.model.ProdutoCriar;
import org.serratec.trabalhoFinalApi.service.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "Produto", description = "Pacote contendo as requisições envolvendo produtos")
@RequestMapping("/produto")
@RestController
@AllArgsConstructor
public class ProdutoController {

    private ProdutoService produtoService;

    @Operation(summary = "Cadastrar produto", description = "Cadastra um novo produto no sistema")
    @ApiResponses(value = {
            @ApiResponse (description = "Produto criado com sucesso", responseCode = "201"),
            @ApiResponse (description = "Dados informados inválidos", responseCode = "400", content = @Content(schema = @Schema(implementation = MensagemErroSwagger.class))),
            @ApiResponse (description = "Dados não encontrados", responseCode = "404", content = @Content(schema = @Schema(implementation = MensagemErroSwagger.class))),
            @ApiResponse (description = "Erro interno no servidor", responseCode = "500", content = @Content(schema = @Schema(implementation = MensagemErroSwagger.class)))
    })
    @PostMapping
    public ResponseEntity<MensagemSucesso> cadastrarProduto(@RequestBody @Valid ProdutoCriar produtoCriar){
        produtoService.cadastrarProduto(produtoCriar);
        return ResponseEntity.status(HttpStatus.CREATED).body(new MensagemSucesso("Produto criado com sucesso!"));
    }

    @Operation(summary = "Buscar produtos", description = "Busca produtos por: ID, nome, status ou nome da categoria do produto.")
    @ApiResponses(value = {
            @ApiResponse (description = "Produtos encontrados com sucesso", responseCode = "200"),
            @ApiResponse (description = "Dados informados inválidos", responseCode = "400", content = @Content(schema = @Schema(implementation = MensagemErroSwagger.class))),
            @ApiResponse (description = "Dados não encontrados", responseCode = "404", content = @Content(schema = @Schema(implementation = MensagemErroSwagger.class))),
            @ApiResponse (description = "Erro interno no servidor", responseCode = "500", content = @Content(schema = @Schema(implementation = MensagemErroSwagger.class)))
    })
    @GetMapping
    public ResponseEntity<List<ProdutoBuscar>> buscarProduto(@RequestParam(required = false) UUID id, @RequestParam(required = false) String nome, @RequestParam(required = false) Boolean ativo, @RequestParam(required = false) String categoriaNome){
        List<ProdutoBuscar> produtos = produtoService.buscarProduto(id, ativo, nome, categoriaNome);
        return ResponseEntity.status(HttpStatus.OK).body(produtos);
    }


    @Operation(summary = "Atualizar produto", description = "Atualiza os dados de um produto existente por ID")
    @ApiResponses(value = {
            @ApiResponse (description = "Produto atualizado com sucesso", responseCode = "200"),
            @ApiResponse (description = "Dados informados inválidos", responseCode = "400", content = @Content(schema = @Schema(implementation = MensagemErroSwagger.class))),
            @ApiResponse (description = "Dados não encontrados", responseCode = "404", content = @Content(schema = @Schema(implementation = MensagemErroSwagger.class))),
            @ApiResponse (description = "Erro interno no servidor", responseCode = "500", content = @Content(schema = @Schema(implementation = MensagemErroSwagger.class)))
    })
    @PutMapping("/{id}")
    public ResponseEntity<MensagemSucesso> atualizarProduto(@PathVariable UUID id, @RequestBody @Valid ProdutoAtualizar produto){
        produtoService.atualizarProduto(id, produto);
        return ResponseEntity.status(HttpStatus.OK).body(new MensagemSucesso("Produto atualizado com sucesso!"));
    }

    @Operation(summary = "Deletar produto", description = "Deleta o produto por ID")
    @ApiResponses(value = {
            @ApiResponse (description = "Produto deletado com sucesso", responseCode = "204"),
            @ApiResponse (description = "Dados informados inválidos", responseCode = "400", content = @Content(schema = @Schema(implementation = MensagemErroSwagger.class))),
            @ApiResponse (description = "Dados não encontrados", responseCode = "404", content = @Content(schema = @Schema(implementation = MensagemErroSwagger.class))),
            @ApiResponse (description = "Erro interno no servidor", responseCode = "500", content = @Content(schema = @Schema(implementation = MensagemErroSwagger.class)))
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable UUID id){
        produtoService.deletarProduto(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
