package org.serratec.trabalhoFinalApi.repository;

import jakarta.validation.constraints.NotBlank;
import org.serratec.trabalhoFinalApi.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, UUID> {

    Optional<Object> findByCpf(@NotBlank String cpf);

    @Query("SELECT c FROM Cliente c WHERE " +
            "DAY(c.dataNascimento) = :dia AND MONTH(c.dataNascimento) = :mes")
    List<Cliente> findAniversariantesDoDia(@Param("dia") int dia, @Param("mes") int mes);

    Optional<Cliente> findByEmail(String email);
}
