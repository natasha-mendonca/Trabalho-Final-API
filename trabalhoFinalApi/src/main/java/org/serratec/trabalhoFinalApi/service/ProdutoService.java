package org.serratec.trabalhoFinalApi.service;

import lombok.AllArgsConstructor;
import org.serratec.trabalhoFinalApi.entity.Categoria;
import org.serratec.trabalhoFinalApi.entity.Produto;
import org.serratec.trabalhoFinalApi.model.ProdutoAtualizar;
import org.serratec.trabalhoFinalApi.model.ProdutoBuscar;
import org.serratec.trabalhoFinalApi.model.ProdutoCriar;
import org.serratec.trabalhoFinalApi.repository.CategoriaRepository;
import org.serratec.trabalhoFinalApi.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@Service
public class ProdutoService {

    private ProdutoRepository produtoRepository;
    private CategoriaRepository categoriaRepository;

    public List<ProdutoBuscar> buscarProduto(UUID id, Boolean ativo, String nome, String categoriaNome){
        List<Produto> produtos = new ArrayList<>();

        if(id == null && ativo == null && nome == null && categoriaNome == null){
            produtos = this.produtoRepository.findAll();
        } else if (id != null) {
            Optional<Produto> produto = this.produtoRepository.findById(id);
            if(produto.isEmpty()){
            }
            produtos.add(produto.get());
        } else if (nome != null && !nome.isBlank()){
            produtos = this.produtoRepository.findByNome(nome);
        } else if (ativo != null){
            produtos = this.produtoRepository.findByAtivo(ativo);
        } else if (categoriaNome != null && !categoriaNome.isBlank()){
            produtos = this.produtoRepository.findByCategoriaNome(categoriaNome);
        }

        return produtos
                .stream()
                .map(produto -> new ProdutoBuscar(produto))
                .toList();
    }

    public ProdutoBuscar cadastrarProduto(ProdutoCriar produtoCriar){
        Optional<Categoria> categoriaOpt = categoriaRepository.findById(produtoCriar.getCategoriaId());

        if(categoriaOpt.isEmpty()){
            throw new RuntimeException();
        }

        Produto produto = new Produto(produtoCriar, categoriaOpt.get());
        return new ProdutoBuscar(produtoRepository.save(produto));

    }

    public void deletarProduto(UUID id){
        if(!produtoRepository.existsById(id)){
            throw new RuntimeException();
        }
        this.produtoRepository.deleteById(id);
    }

    public ProdutoAtualizar atualizarProduto(UUID id, ProdutoAtualizar produto) {
        Optional<Produto> produtoOpt = produtoRepository.findById(id);

        if (produtoOpt.isEmpty()) {
            throw new RuntimeException();
        }
        Produto produtoExistente = produtoOpt.get();

        if (produto.getNome() != null) {
            produtoExistente.setNome(produto.getNome());
        }

        if (produto.getPreco() != null) {
            produtoExistente.setPreco(produto.getPreco());
        }

        if (produto.getDescricao() != null) {
            produtoExistente.setDescricao(produto.getDescricao());
        }

        if (produto.getEstoque() != null) {
            produtoExistente.setEstoque(produto.getEstoque());
        }

        if (produto.getAtivo() != null) {
            produtoExistente.setAtivo(produto.getAtivo());
        }

        if (produto.getCategoriaId() != null) {
            Optional<Categoria> categoria = categoriaRepository.findById(id);
            if (categoria.isEmpty()){
                throw new RuntimeException();
            }
            produtoExistente.setCategoria(categoria.get());
        }

        return new ProdutoAtualizar(produtoRepository.save(produtoExistente));
    }
}
