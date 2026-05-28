package org.serratec.trabalhoFinalApi.repository;

import org.serratec.trabalhoFinalApi.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface ProdutoRepository extends JpaRepository<Produto, UUID> {
    List<Produto> findByNomeContainingIgnoreCase(String nome);

    List<Produto> findByAtivo(Boolean ativo);

    List<Produto> findByCategoriaNomeContainingIgnoreCase(String categoriaNome);

    @Query(value = """
        select p.id, p.nome, c.nome, sum(ip.quantidade), sum((ip.valor_venda - ip.desconto) * ip.quantidade)
        from produto p
        join categoria c on c.id = p.categoria_id
        join item_pedido ip on ip.produto_id = p.id
        group by p.id, p.nome, c.nome
        order by sum(ip.quantidade) DESC
""", nativeQuery = true)
    List<Object[]> buscarMaisVendidos();

    Boolean existsByCategoriaId(UUID categoriaId);
}
