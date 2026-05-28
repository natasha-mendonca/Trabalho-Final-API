package org.serratec.trabalhoFinalApi.repository;

import org.serratec.trabalhoFinalApi.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, UUID> {

    Optional<Pedido> findByCodigoRastreio (String codigoRastreio);

    @Query("SELECT SUM(i.subTotal) FROM Pedido p JOIN p.itens i WHERE p.dataPedido BETWEEN :inicio AND :fim")
    Double somarFaturamento(@Param("inicio") LocalDateTime inicio, @Param("fim") LocalDateTime fim);

}