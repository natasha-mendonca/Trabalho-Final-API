package org.serratec.trabalhoFinalApi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.serratec.trabalhoFinalApi.entity.Cliente;
import org.serratec.trabalhoFinalApi.exception.generalista.MensagemErroSwagger;
import org.serratec.trabalhoFinalApi.model.ClienteDto.ClienteAtualizar;
import org.serratec.trabalhoFinalApi.model.ClienteDto.ClienteBuscar;
import org.serratec.trabalhoFinalApi.model.ClienteDto.ClienteCriar;
import org.serratec.trabalhoFinalApi.model.MensagemSucesso;
import org.serratec.trabalhoFinalApi.service.ClienteService;
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

    private ClienteService clienteService;

    public ClienteController (ClienteService clienteService) {
        this.clienteService = clienteService;
    }



    @Operation(summary = "Buscar cliente por id", description = "Retorna um cliente especificado pelo ID")
    @ApiResponses(value = {@ApiResponse(description = "Busca de cliente retornado", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ClienteBuscar.class))),
            @ApiResponse(description = "Dados informados inválidos", responseCode = "400", content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = MensagemErroSwagger.class))),
            @ApiResponse(description = "Dados não encontrados", responseCode = "404", content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = MensagemErroSwagger.class))),
            @ApiResponse(description = "Erro inteiro no servidor", responseCode = "500", content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation =  MensagemErroSwagger.class)))})
    @GetMapping("/{id}")
    public ResponseEntity<ClienteBuscar> buscarPorId(@Parameter (description = "UUID do cliente a ser buscado", required = true) @PathVariable UUID id) {
        Cliente cliente = this.clienteService.buscarCliente(id);
        return ResponseEntity.status(OK).body(new ClienteBuscar(cliente));
    }

    @PostMapping
    @Operation (summary = "Cadastra um novo cliente", description = "Insercao de um novo cliente no sistema")
    @ApiResponses (value = {
            @ApiResponse (responseCode = "201", description = "Cliente cadastrado com sucesso", content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = MensagemSucesso.class))),
            @ApiResponse (responseCode = "400", description = "Dados inválidos na requisição", content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = MensagemErroSwagger.class)
            )),
            @ApiResponse (responseCode = "404", description = "Dados nao encontrados", content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = MensagemErroSwagger.class))
            ),
            @ApiResponse (responseCode = "409", description = "Dados já existentes", content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = MensagemErroSwagger.class)
            )),
            @ApiResponse (responseCode = "500", description = "Erro interno no servidor", content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = MensagemErroSwagger.class)))
    })
    public ResponseEntity<MensagemSucesso> inserirCliente(@io.swagger.v3.oas.annotations.parameters.RequestBody (description = "Dados necessários para cadastrar um novo cliente", required = true)
    @RequestBody @Valid ClienteCriar cliente) {

        this.clienteService.inserirCliente(cliente);
        return ResponseEntity.status(CREATED).body(new MensagemSucesso("Cliente cadastrado com sucesso!"));
    }

        @Operation(summary = "Exclui um cliente", description = "Remocao de um cliente mediante a um ID")
        @ApiResponses(value = {@ApiResponse(description = "Pedido removido com sucesso", responseCode = "204"),
                @ApiResponse(description = "Dados informados inválidos", responseCode = "400", content = @Content(
                        mediaType = "application/json",
                        schema = @Schema(implementation =  MensagemErroSwagger.class))),
                @ApiResponse(description = "Dados não encontrados", responseCode = "404", content = @Content(
                        mediaType = "application/json",
                        schema = @Schema(implementation =  MensagemErroSwagger.class))),
                @ApiResponse(description = "Erro inteiro no servidor", responseCode = "500", content = @Content(
                        mediaType = "application/json",
                        schema = @Schema(implementation =  MensagemErroSwagger.class)))})
        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteCliente(@Parameter (description = "UUID do cliente a ser deletado", required = true)
            @PathVariable UUID id){
            clienteService.deletarCliente(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }


    @Operation(summary = "Atualizar cliente", description = "Atualizar dados de um cliente")
    @ApiResponses(value = {@ApiResponse(description = "Cliente atualizado com sucesso", responseCode = "200", content = @Content(mediaType = "application/json",
            schema = @Schema(implementation = MensagemSucesso.class))),
            @ApiResponse(description = "Dados informados inválidos", responseCode = "400", content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation =  MensagemErroSwagger.class))),
            @ApiResponse(description = "Dados não encontrados", responseCode = "404", content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation =  MensagemErroSwagger.class))),
            @ApiResponse(description = "Erro inteiro no servidor", responseCode = "500", content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation =  MensagemErroSwagger.class)))})
    @PutMapping("/{id}")
    public ResponseEntity<MensagemSucesso> atualizarCliente(
            @Parameter(description = "UUID do cliente a ser atualizado", required = true)
            @PathVariable UUID id,
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Dados para atualizar o cliente", required = true)
            @RequestBody @Valid ClienteAtualizar cliente) {

        this.clienteService.atualizarCliente(id, cliente);
        return ResponseEntity.status(OK).body(new MensagemSucesso("Cliente atualizado com sucesso!"));
    }
}