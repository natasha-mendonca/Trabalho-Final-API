package org.serratec.trabalhoFinalApi.service;

import lombok.AllArgsConstructor;
import org.serratec.trabalhoFinalApi.entity.Categoria;
import org.serratec.trabalhoFinalApi.model.*;
import org.serratec.trabalhoFinalApi.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@Service
public class CategoriaService {

    private CategoriaRepository categoriaRepository;

    public List<CategoriaBuscar> buscarCategoria(UUID id, String nome){
        List<Categoria> categorias = new ArrayList<>();

        if(id == null  && nome == null){
            categorias = this.categoriaRepository.findAll();
        } else if (id != null) {
            Optional<Categoria> categoria = this.categoriaRepository.findById(id);
            if(categoria.isEmpty()){
            }
            categorias.add(categoria.get());
        } else if (nome != null && !nome.isBlank()){
            categorias = this.categoriaRepository.findByNome(nome);
        }

        return categorias
                .stream()
                .map(categoria -> new CategoriaBuscar(categoria))
                .toList();
    }

    public CategoriaBuscar cadastrarCategoria(CategoriaCriar categoriaCriar){
        Categoria categoria = new Categoria(categoriaCriar);
        return new CategoriaBuscar(categoriaRepository.save(categoria));

    }

    public void deletarCategoria(UUID id){
        if(!categoriaRepository.existsById(id)){
            throw new RuntimeException();
        }
        this.categoriaRepository.deleteById(id);
    }

    public CategoriaAtualizar atualizarCategoria(UUID id, CategoriaAtualizar categoria) {
        Optional<Categoria> categoriaoOpt = categoriaRepository.findById(id);

        if (categoriaoOpt.isEmpty()) {
            throw new RuntimeException();
        }
        Categoria categoriaExistente = categoriaoOpt.get();

        if (categoria.getNome() != null) {
            categoriaExistente.setNome(categoria.getNome());
        }

        return new CategoriaAtualizar(categoriaRepository.save(categoriaExistente));
    }
}
