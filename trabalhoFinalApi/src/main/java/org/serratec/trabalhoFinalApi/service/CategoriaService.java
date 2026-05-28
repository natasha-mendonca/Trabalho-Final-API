package org.serratec.trabalhoFinalApi.service;

import lombok.AllArgsConstructor;
import org.serratec.trabalhoFinalApi.entity.Categoria;
import org.serratec.trabalhoFinalApi.exception.catalogo.CategoriaConflitoProdutosException;
import org.serratec.trabalhoFinalApi.exception.catalogo.CategoriaJaCadastrada;
import org.serratec.trabalhoFinalApi.exception.catalogo.CategoriaPaiNaoEncontradaException;
import org.serratec.trabalhoFinalApi.exception.generalista.RequisicaoNaoEncontradoException;
import org.serratec.trabalhoFinalApi.model.CategoriaDto.CategoriaAtualizar;
import org.serratec.trabalhoFinalApi.model.CategoriaDto.CategoriaBuscar;
import org.serratec.trabalhoFinalApi.model.CategoriaDto.CategoriaCriar;
import org.serratec.trabalhoFinalApi.repository.CategoriaRepository;
import org.serratec.trabalhoFinalApi.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@Service
public class CategoriaService {

    private ProdutoRepository produtoRepository;
    private CategoriaRepository categoriaRepository;

    public List<CategoriaBuscar> buscarCategoria(UUID id, String nome){
        List<Categoria> categorias = new ArrayList<>();

        if(id == null  && nome == null){
            categorias = this.categoriaRepository.findAll();
        } else if (id != null) {
            Optional<Categoria> categoria = this.categoriaRepository.findById(id);
            if(categoria.isEmpty()){
                throw new RequisicaoNaoEncontradoException("O id ou o nome especificado nao condiz com um existente no banco de dados");
            }
            categorias.add(categoria.get());
        } else if (nome != null && !nome.isBlank()){
            categorias = this.categoriaRepository.findByNomeContainingIgnoreCase(nome);
        }

        if(categorias.isEmpty()){
            throw new RequisicaoNaoEncontradoException("Nenhuma categoria encontrada");
        }

        return categorias
                .stream()
                .map(categoria -> new CategoriaBuscar(categoria))
                .toList();
    }

    public CategoriaBuscar cadastrarCategoria(CategoriaCriar categoriaCriar){
        if(categoriaRepository.existsByNomeIgnoreCase(categoriaCriar.getNome())){
            throw new CategoriaJaCadastrada(categoriaCriar.getNome());
        }
        Categoria categoria = new Categoria(categoriaCriar);
        return new CategoriaBuscar(categoriaRepository.save(categoria));

    }

    public void deletarCategoria(UUID id){
        if(!categoriaRepository.existsById(id)){
            throw new RequisicaoNaoEncontradoException("O id especificado nao existe no banco de dados");
        }
        if(produtoRepository.existsByCategoriaId(id)){
            throw new CategoriaConflitoProdutosException(id);
        }
        this.categoriaRepository.deleteById(id);
    }

    public void atualizarCategoria(UUID id, CategoriaAtualizar categoria) {

        Optional<Categoria> categoriaoOpt = categoriaRepository.findById(id);

        if (categoriaoOpt.isEmpty()) {
            throw new CategoriaPaiNaoEncontradaException(id);
        }
        Categoria categoriaExistente = categoriaoOpt.get();

        if (categoria.getNome() != null && !categoria.getNome().isBlank()) {
            categoriaExistente.setNome(categoria.getNome());
        }

        categoriaRepository.save(categoriaExistente);
    }
}
