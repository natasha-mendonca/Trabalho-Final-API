package org.serratec.trabalhoFinalApi.repository;

import jakarta.validation.constraints.NotBlank;
import org.serratec.trabalhoFinalApi.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClienteRepository extends JpaRepository<Cliente, UUID> {
    List<Cliente> findAll();
    
    Cliente save(Cliente cliente1);

    Optional<Object> findByCpf(@NotBlank String cpf);
}
