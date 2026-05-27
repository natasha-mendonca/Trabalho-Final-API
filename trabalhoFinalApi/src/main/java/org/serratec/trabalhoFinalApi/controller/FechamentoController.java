package org.serratec.trabalhoFinalApi.controller;

import org.serratec.trabalhoFinalApi.service.FechamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/financeiro/fechamento")
public class FechamentoController {

    @Autowired
    private FechamentoService fechamentoService;

    @GetMapping("/{tipo}")
    public ResponseEntity<Map<String, Object>> obterFechamento(@PathVariable String tipo) {
        Double valorTotal = fechamentoService.calcularFaturamento(tipo);

        Map<String, Object> resposta = new LinkedHashMap<>();
        resposta.put("status", "sucesso");
        resposta.put("tipo_relatorio", tipo.toUpperCase());
        resposta.put("valor_total", valorTotal);

        return ResponseEntity.ok(resposta);
    }
}