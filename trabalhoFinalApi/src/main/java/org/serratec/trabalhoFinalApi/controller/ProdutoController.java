package org.serratec.trabalhoFinalApi.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.serratec.trabalhoFinalApi.model.ProdutoDto.ProdutoAtualizar;
import org.serratec.trabalhoFinalApi.model.ProdutoDto.ProdutoBuscar;
import org.serratec.trabalhoFinalApi.model.ProdutoDto.ProdutoCriar;
import org.serratec.trabalhoFinalApi.service.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/produto")
@RestController
@AllArgsConstructor
public class ProdutoController {

    private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<ProdutoBuscar>> buscarProduto(@RequestParam(required = false) UUID id, @RequestParam(required = false) String nome, @RequestParam(required = false) Boolean ativo, @RequestParam(required = false) String categoriaNome){
        List<ProdutoBuscar> produtos = produtoService.buscarProduto(id, ativo, nome, categoriaNome);
        return ResponseEntity.status(HttpStatus.OK).body(produtos);
    }

    @PostMapping
    public ResponseEntity<ProdutoBuscar> cadastrarProduto(@RequestBody @Valid ProdutoCriar produtoCriar){
        ProdutoBuscar produto = produtoService.cadastrarProduto(produtoCriar);
        return ResponseEntity.status(HttpStatus.CREATED).body(produto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoAtualizar> atualizarProduto(@PathVariable UUID id, @RequestBody @Valid ProdutoAtualizar produto){
        ProdutoAtualizar produtoAtualizado = produtoService.atualizarProduto(id, produto);
        return ResponseEntity.ok(produtoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable UUID id){
        produtoService.deletarProduto(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
