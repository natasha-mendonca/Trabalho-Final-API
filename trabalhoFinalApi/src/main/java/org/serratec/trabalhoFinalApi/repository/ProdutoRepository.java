package org.serratec.trabalhoFinalApi.repository;

import org.serratec.trabalhoFinalApi.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ProdutoRepository extends JpaRepository<Produto, UUID> {
    List<Produto> findByNome(String nome);

    List<Produto> findByAtivo(Boolean ativo);

    List<Produto> findByCategoriaNome(String categoriaNome);
}
