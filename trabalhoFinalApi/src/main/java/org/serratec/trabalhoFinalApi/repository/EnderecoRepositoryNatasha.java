package org.serratec.trabalhoFinalApi.repository;

import org.serratec.trabalhoFinalApi.entity.EnderecoNatasha;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EnderecoRepositoryNatasha extends JpaRepository<EnderecoNatasha, UUID> {
}
