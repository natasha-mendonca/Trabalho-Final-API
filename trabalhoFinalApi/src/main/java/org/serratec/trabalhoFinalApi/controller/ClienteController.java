package org.serratec.trabalhoFinalApi.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.serratec.trabalhoFinalApi.entity.Cliente;
import org.serratec.trabalhoFinalApi.model.ClienteCriar;
import org.serratec.trabalhoFinalApi.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import java.util.UUID;


@RequestMapping("cliente")
@RestController
@Tag(name = "Cliente", description = "Pacote contendo as requisições envolvendo clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    public ClienteController (ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable UUID id) {
        Cliente cliente = this.clienteService.buscarCliente(id);
        return ResponseEntity.status(OK).body(cliente);
    }

    @PostMapping
    public ResponseEntity<Void> inserirCliente(@RequestBody @Valid ClienteCriar cliente) {

        this.clienteService.inserirCliente(cliente);
        return ResponseEntity.status(CREATED).build();
    }
}