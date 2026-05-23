package org.serratec.trabalhoFinalApi.repository;

import org.serratec.trabalhoFinalApi.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoriaRepository extends JpaRepository<Categoria, UUID> {
}
