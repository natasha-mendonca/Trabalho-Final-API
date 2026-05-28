package org.serratec.trabalhoFinalApi.service;

import org.serratec.trabalhoFinalApi.exception.generalista.RequisicaoMalRealizadaException;
import org.serratec.trabalhoFinalApi.exception.generalista.RequisicaoNaoEncontradoException;
import org.serratec.trabalhoFinalApi.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class FechamentoService {

    private PedidoRepository pedidoRepository;

    public FechamentoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public Double calcularFaturamento(String tipo) {
        LocalDateTime fim = LocalDateTime.now();
        LocalDateTime inicio;

        switch (tipo.toLowerCase()) {
            case "hoje":
                inicio = fim.toLocalDate().atStartOfDay();
                break;
            case "semana":
                inicio = fim.minusDays(7);
                break;
            case "mes":
                inicio = fim.minusDays(30);
                break;
            case "ano":
                inicio = LocalDateTime.of(fim.getYear(), 1, 1, 0, 0);
                break;
            default:
                throw new RequisicaoMalRealizadaException("Tipo de relatório é inválido. Use o tipo: hoje, semana ou ano.");
        }

        Double total = pedidoRepository.somarFaturamento(inicio, fim);

        if(total == null || total == 0.0){
            throw new RequisicaoNaoEncontradoException("O registro nao consta no banco");
        }
        return total;
    }
}