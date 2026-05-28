package org.serratec.trabalhoFinalApi.repository;

import org.serratec.trabalhoFinalApi.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CategoriaRepository extends JpaRepository<Categoria, UUID> {
    List<Categoria> findByNomeContainingIgnoreCase(String nome);

    boolean existsByNomeIgnoreCase(String nome);
}
