package org.serratec.trabalhoFinalApi.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.serratec.trabalhoFinalApi.model.CategoriaAtualizar;
import org.serratec.trabalhoFinalApi.model.CategoriaBuscar;
import org.serratec.trabalhoFinalApi.model.CategoriaCriar;
import org.serratec.trabalhoFinalApi.service.CategoriaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/categoria")
public class CategoriaController {
    private CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<List<CategoriaBuscar>> buscarCategoria(@RequestParam(required = false) UUID id, @RequestParam(required = false) String nome){
        List<CategoriaBuscar> categorias = categoriaService.buscarCategoria(id, nome);
        return ResponseEntity.status(HttpStatus.OK).body(categorias);
    }

    @PostMapping
    public ResponseEntity<CategoriaBuscar> cadastrarCategoria(@RequestBody @Valid CategoriaCriar categoriaCriar){
        CategoriaBuscar categoria = categoriaService.cadastrarCategoria(categoriaCriar);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoria);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaAtualizar> atualizarCategoria(@PathVariable UUID id, @RequestBody @Valid CategoriaAtualizar categoria){
        CategoriaAtualizar categoriaAtualizado = categoriaService.atualizarCategoria(id, categoria);
        return ResponseEntity.ok(categoriaAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCategoria(@PathVariable UUID id){
        categoriaService.deletarCategoria(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
