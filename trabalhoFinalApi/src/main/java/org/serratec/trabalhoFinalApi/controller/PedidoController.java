package org.serratec.trabalhoFinalApi.controller;

// ------ NECESSITA CONECTAR COM A TABELA PRODUTO E CLIENTE---------
// TIRAR OS COMENTARIOS GERAIS QUANDO PRODUTO E CLIENTE ESTIVEREM FUNCIONANDO


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.serratec.trabalhoFinalApi.model.MensagemSucesso;
import org.serratec.trabalhoFinalApi.model.PedidoAtualiza;
import org.serratec.trabalhoFinalApi.model.PedidoBuscar;
import org.serratec.trabalhoFinalApi.service.PedidoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    //CRIAR A CLASSE ERRORESPONSE
//    @Operation(summary = "Criar", description = "Insere dados do pedido no sistema")
//    @ApiResponses(value = {@ApiResponse(description = "Pedido criado com sucesso", responseCode = "201"),
//                           @ApiResponse(description = "Dados invalidos", responseCode = "400", content = @Content(
//                                   mediaType = "application/json",
//                                   schema = @Schema(implementation = ErrorResponse.class))),
//                           @ApiResponse(description = "Dados não encontrados", responseCode = "404", content = @Content(
//                                   mediaType = "applicaton/json",
//                                   schema = @Schema(implementation = ErrorResponse.class))),
//                           @ApiResponse(description = "Dados já existentes", responseCode = "409", content = @Content(
//                                   mediaType = "application/json",
//                                   schema = @Schema(implementation = ErrorResponse.class))),
//                           @ApiResponse(description = "Erro inteiro no servidor", responseCode = "500", content = @Content(
//                                   mediaType = "application/json",
//                                   schema = @Schema(implementation = ErrorResponse.class)))})
//    @PostMapping
//    ResponseEntity<Void> criar (@RequestBody @Valid PedidoCriar pedidoCriar){
//
//        this.pedidoService.inserirPedido(pedidoCriar);
//        return  ResponseEntity.ok().build();
//    }

    @Operation(summary = "Buscar pedido por id", description = "Retorna um pedido especificado pelo ID")
    @ApiResponses(value = {@ApiResponse(description = "Busca de pedido retornada", responseCode = "200"),
                           @ApiResponse(description = "Dados informados inválidos", responseCode = "400", content = @Content(
                                   mediaType = "application/json",
                                   schema = @Schema(implementation = ErrorResponse.class))),
                           @ApiResponse(description = "Dados não encontrados", responseCode = "404", content = @Content(
                                   mediaType = "application/json",
                                   schema = @Schema(implementation = ErrorResponse.class))),
                           @ApiResponse(description = "Erro inteiro no servidor", responseCode = "500", content = @Content(
                                   mediaType = "application/json",
                                   schema = @Schema(implementation = ErrorResponse.class)))})
    @GetMapping("/{id}")
    ResponseEntity<PedidoBuscar> listarPedido(@Parameter(description = "Id do pedido", example = "87fe4a1d-a281-45c4-bc96-8547507785bf")
                                              @PathVariable UUID id){
        return ResponseEntity.ok(this.pedidoService.listarPedido(id));
    }

    @Operation(summary = "Atualizar pedido", description = "Atualizados dados de um pedido")
    @ApiResponses(value = {@ApiResponse(description = "Veiculo atualizado com sucesso", responseCode = "200"),
                           @ApiResponse(description = "Dados informados inválidos", responseCode = "400", content = @Content(
                                   mediaType = "application/json",
                                   schema = @Schema(implementation = ErrorResponse.class))),
                           @ApiResponse(description = "Dados não encontrados", responseCode = "404", content = @Content(
                                   mediaType = "application/json",
                                   schema = @Schema(implementation = ErrorResponse.class))),
                           @ApiResponse(description = "Erro inteiro no servidor", responseCode = "500", content = @Content(
                                   mediaType = "application/json",
                                   schema = @Schema(implementation = ErrorResponse.class)))})
    @PutMapping("/{id}")
    ResponseEntity<MensagemSucesso> atualizar(@Parameter(description = "Id do pedido", example = "87fe4a1d-a281-45c4-bc96-8547507785bf")
                                              @PathVariable UUID id, @Valid @RequestBody PedidoAtualiza pedidoAtualiza){
        this.pedidoService.atualizarPedido(id, pedidoAtualiza);
        return ResponseEntity.status(HttpStatus.OK).body(new MensagemSucesso("Pedido atualizado com sucesso!"));
    }

    @Operation(summary = "Deletar pedido", description = "Delecao de um pedido mediante a um ID")
    @ApiResponses(value = {@ApiResponse(description = "Pedido removido com sucesso", responseCode = "204"),
                           @ApiResponse(description = "Dados informados inválidos", responseCode = "400", content = @Content(
                                   mediaType = "application/json",
                                   schema = @Schema(implementation = ErrorResponse.class))),
                           @ApiResponse(description = "Dados não encontrados", responseCode = "404", content = @Content(
                                   mediaType = "application/json",
                                   schema = @Schema(implementation = ErrorResponse.class))),
                           @ApiResponse(description = "Erro inteiro no servidor", responseCode = "500", content = @Content(
                                   mediaType = "application/json",
                                   schema = @Schema(implementation = ErrorResponse.class)))})
    @DeleteMapping("/{id}")
    ResponseEntity<MensagemSucesso> deletar(@Parameter(description = "Id do pedido", example = "87fe4a1d-a281-45c4-bc96-8547507785bf")
                                            @PathVariable UUID id){

        this.pedidoService.deletarPedido(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new MensagemSucesso("Pedido deletado com sucesso!"));
    }


//    @GetMapping
    //ADICIONAR A FUNCIONALIADE PAGABLE
//    ResponseEntity<PedidoBuscar> buscar(@RequestParam (required = false)UUID id){
//
//        return  ;
//    }


}
