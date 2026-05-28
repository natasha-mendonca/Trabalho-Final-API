package org.serratec.trabalhoFinalApi.service;

import lombok.AllArgsConstructor;
import org.serratec.trabalhoFinalApi.entity.Categoria;
import org.serratec.trabalhoFinalApi.entity.Produto;
import org.serratec.trabalhoFinalApi.exception.catalogo.CategoriaPaiNaoEncontradaException;
import org.serratec.trabalhoFinalApi.exception.catalogo.ProdutoNaoEncontradoException;
import org.serratec.trabalhoFinalApi.exception.generalista.RequisicaoNaoEncontradoException;
import org.serratec.trabalhoFinalApi.exception.venda.EstoqueInsuficienteException;
import org.serratec.trabalhoFinalApi.model.*;
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

    public Produto buscarProdutoId(UUID id) {
        return this.produtoRepository.findById(id).orElseThrow(() -> new ProdutoNaoEncontradoException(id));
    }

    public List<ProdutoBuscar> buscarProduto(UUID id, Boolean ativo, String nome, String categoriaNome){
        List<Produto> produtos = new ArrayList<>();

        if(id == null && ativo == null && nome == null && categoriaNome == null){
            produtos = this.produtoRepository.findAll();
        } else if (id != null) {
            produtos.add(buscarProdutoId(id));
        } else if (nome != null && !nome.isBlank()){
            produtos = this.produtoRepository.findByNomeContainingIgnoreCase(nome);
        } else if (ativo != null){
            produtos = this.produtoRepository.findByAtivo(ativo);
        } else if (categoriaNome != null && !categoriaNome.isBlank()){
            produtos = this.produtoRepository.findByCategoriaNomeContainingIgnoreCase(categoriaNome);
        }

        if(produtos.isEmpty()){
            throw new RequisicaoNaoEncontradoException("Nenhum produto encontrado");
        }

        return produtos
                .stream()
                .map(produto -> new ProdutoBuscar(produto))
                .toList();
    }

    public ProdutoBuscar cadastrarProduto(ProdutoCriar produtoCriar){
        Optional<Categoria> categoriaOpt = categoriaRepository.findById(produtoCriar.getCategoriaId());

        if(categoriaOpt.isEmpty()){
            throw new CategoriaPaiNaoEncontradaException(produtoCriar.getCategoriaId());
        }

        Produto produto = new Produto(produtoCriar, categoriaOpt.get());
        return new ProdutoBuscar(produtoRepository.save(produto));

    }

    public void deletarProduto(UUID id){
        if(!produtoRepository.existsById(id)){
            throw new ProdutoNaoEncontradoException(id);
        }
        this.produtoRepository.deleteById(id);
    }

    public void atualizarProduto(UUID id, ProdutoAtualizar produto) {
        Optional<Produto> produtoOpt = produtoRepository.findById(id);

        if (produtoOpt.isEmpty()) {
            throw new ProdutoNaoEncontradoException(id);
        }
        Produto produtoExistente = produtoOpt.get();

        if (produto.getNome() != null && !produto.getNome().isBlank()) {
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
            Optional<Categoria> categoria = categoriaRepository.findById(produto.getCategoriaId());
            if (categoria.isEmpty()){
                throw new CategoriaPaiNaoEncontradaException(produto.getCategoriaId());
            }
            produtoExistente.setCategoria(categoria.get());
        }

        produtoRepository.save(produtoExistente);
    }

    public void atualizarEstoque(UUID id, Integer quant){
        Produto produto = buscarProdutoId(id);

        if(produto.getEstoque() < quant){
            throw new EstoqueInsuficienteException(produto.getNome(), quant);
        }

        produto.setEstoque(produto.getEstoque() - quant);
        produtoRepository.save(produto);
    }

    public List<ProdutoRelatorio> buscarProdutosMaisVendidos() {
        List<Object[]> resultado  = produtoRepository.buscarMaisVendidos();

        List<ProdutoRelatorio> relatorio = new ArrayList<>();

        for(Object[] linha : resultado){
            ProdutoRelatorio produto = new ProdutoRelatorio();
            produto.setId(UUID.fromString(linha[0].toString()));
            produto.setNome(linha[1].toString());
            produto.setCategoriaNome(linha[2].toString());
            produto.setQuantidadeVendida(((Long) linha[3]).intValue());
            produto.setReceitaTotal((Double) linha[4]);

            relatorio.add(produto);
        }

        if(relatorio.isEmpty()){
            throw new RequisicaoNaoEncontradoException("Não existe pedidos");
        }

        return relatorio;
    }
}
