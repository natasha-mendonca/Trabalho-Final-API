package org.serratec.trabalhoFinalApi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.serratec.trabalhoFinalApi.entity.Pedido;
import org.serratec.trabalhoFinalApi.exception.generalista.MensagemErroSwagger;
import org.serratec.trabalhoFinalApi.exception.generalista.RequisicaoNaoEncontradoException;
import org.serratec.trabalhoFinalApi.exception.venda.PedidoNaoEncontradoException;
import org.serratec.trabalhoFinalApi.model.MensagemSucesso;
import org.serratec.trabalhoFinalApi.model.PedidoAtualiza;
import org.serratec.trabalhoFinalApi.model.PedidoBuscar;
import org.serratec.trabalhoFinalApi.model.PedidoCriar;
import org.serratec.trabalhoFinalApi.service.PedidoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/pedido")
@Tag(name = "Pedido", description = "Pacote contendo as requisições envolvendo pedidos")
public class PedidoController {

    PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    //CRIAR A CLASSE ERRORESPONSE
    @Operation(summary = "Criar pedido", description = "Insere dados do pedido no sistema")
    @ApiResponses(value = {@ApiResponse(description = "Pedido criado com sucesso", responseCode = "201"),
            @ApiResponse(description = "Dados invalidos", responseCode = "400", content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(description = "Dados não encontrados", responseCode = "404", content = @Content(
                    mediaType = "applicaton/json",
                    schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(description = "Dados já existentes", responseCode = "409", content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(description = "Erro inteiro no servidor", responseCode = "500", content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = ErrorResponse.class)))})
    @PostMapping
    ResponseEntity<Void> criar(@RequestBody @Valid PedidoCriar pedidoCriar) {

        this.pedidoService.inserirPedido(pedidoCriar);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Buscar pedido por id", description = "Retorna um pedido especificado pelo ID")
    @ApiResponses(value = {@ApiResponse(description = "Busca de pedido retornada", responseCode = "200"),
            @ApiResponse(description = "Dados informados inválidos", responseCode = "400", content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = MensagemErroSwagger.class))),
            @ApiResponse(description = "Dados não encontrados", responseCode = "404", content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = MensagemErroSwagger.class))),
            @ApiResponse(description = "Erro inteiro no servidor", responseCode = "500", content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = ErrorResponse.class)))})
    @GetMapping("/{id}")
    ResponseEntity<PedidoBuscar> buscar(@Parameter(description = "Id do pedido", example = "87fe4a1d-a281-45c4-bc96-8547507785bf")
                                              @PathVariable UUID id) {
        return ResponseEntity.ok(this.pedidoService.encontrarPedido(id));
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
                                              @PathVariable UUID id, @Valid @RequestBody PedidoAtualiza pedidoAtualiza) {
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
                                            @PathVariable UUID id) {

        this.pedidoService.deletarPedido(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new MensagemSucesso("Pedido deletado com sucesso!"));
    }

    @Operation(summary = "Buscar revisoes", description = "Buscar dados de revisao do pedido")
    @ApiResponses(value = {@ApiResponse(description = "Retorno dos dados de revisao", responseCode = "200"),
            @ApiResponse(description = "Dados invalidos", responseCode = "400", content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(description = "Revisoes não encontrados", responseCode = "404", content = @Content(
                    mediaType = "applicaton/json",
                    schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(description = "Erro inteiro no servidor", responseCode = "500", content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = ErrorResponse.class)))})
    @GetMapping("/revisoes/{id}")
    public ResponseEntity<List<Number>> buscarRevisoes(@PathVariable UUID id) {
        List<Number> revisoes = pedidoService.buscarRevisoes(id);
//        if (revisoes.isEmpty()) {
//            throw new RequisicaoNaoEncontradoException("Nao ha revisao desse pedido pelo id: " + id);
//        }

        return ResponseEntity.ok(revisoes);
    }

//    @GetMapping("/revisoes/{id}/{numeroRevisao}")
//    public ResponseEntity<Pedido> buscarDadosDaRevisao(
//            @PathVariable UUID id,
//            @PathVariable Integer numeroRevisao) {
//
//        // Aqui você chamaria o Envers para trazer a "foto" do pedido
//        // exatamente como ele estava na revisão 5 ou 6
//        Pedido pedidoHistorico = pedidoService.buscarPedidoNaRevisao(id, numeroRevisao);
//
//        return ResponseEntity.ok(pedidoHistorico);
//    }
}


