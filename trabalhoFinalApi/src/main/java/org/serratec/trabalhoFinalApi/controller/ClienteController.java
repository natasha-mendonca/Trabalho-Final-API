package org.serratec.trabalhoFinalApi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.serratec.trabalhoFinalApi.entity.Cliente;
import org.serratec.trabalhoFinalApi.model.ClienteCriar;
import org.serratec.trabalhoFinalApi.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    @Operation(summary = "Busca um cliente pelo ID")
    @ApiResponses(value = {
            @ApiResponse (responseCode = "200", description = "Cliente encontrado com sucesso"),
            @ApiResponse (responseCode = "404", description = "Cliente não encontrado")
    })

    public ResponseEntity<Cliente> buscarPorId(@Parameter (description = "UUID do cliente a ser buscado", required = true) @PathVariable UUID id) {
        Cliente cliente = this.clienteService.buscarCliente(id);
        return ResponseEntity.status(OK).body(cliente);
    }

    @PostMapping
    @Operation (summary = "Cadastra um novo cliente")
    @ApiResponses (value = {
            @ApiResponse (responseCode = "200", description = "Cliente cadastrado com sucesso"),
            @ApiResponse (responseCode = "400", description = "Dados inválidos na requisição")
    })

    public ResponseEntity<Void> inserirCliente(@io.swagger.v3.oas.annotations.parameters.RequestBody (description = "Dados necessários para cadastrar um novo cliente", required = true)
    @RequestBody @Valid ClienteCriar cliente) {

        this.clienteService.inserirCliente(cliente);
        return ResponseEntity.status(CREATED).build();
    }

    @DeleteMapping
    @Operation (summary = "Exclui um cliente")
    public ResponseEntity<Void> deleteCliente(@PathVariable UUID id){

        clienteService.deletarCliente(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}