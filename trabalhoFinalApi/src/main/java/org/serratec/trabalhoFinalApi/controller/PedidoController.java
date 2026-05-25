package org.serratec.trabalhoFinalApi.controller;

    // TIRAR O COMENTARIO GERAL QUANDO O SERVICE DE PEDIDO ESTIVER FUNCIONANDO


import jakarta.validation.Valid;
import org.serratec.trabalhoFinalApi.model.MensagemSucesso;
import org.serratec.trabalhoFinalApi.model.PedidoAtualiza;
import org.serratec.trabalhoFinalApi.model.PedidoBuscar;
import org.serratec.trabalhoFinalApi.model.PedidoCriar;
import org.serratec.trabalhoFinalApi.service.PedidoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping
    ResponseEntity<Void> criar (@RequestBody @Valid PedidoCriar pedidoCriar){

        this.pedidoService.inserirPedido(pedidoCriar);
        return  ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    ResponseEntity<PedidoBuscar> listarPedido(@PathVariable UUID id){
        return ResponseEntity.ok(this.pedidoService.listarPedido(id));
    }

    @PutMapping("/{id}")
    ResponseEntity<MensagemSucesso> atualizar(@PathVariable UUID id, @Valid @RequestBody PedidoAtualiza pedidoAtualiza){
        this.pedidoService.atualizarPedido(id, pedidoAtualiza);
        return ResponseEntity.status(HttpStatus.OK).body(new MensagemSucesso("Pedido atualizado com sucesso!"));
    }



    @DeleteMapping("/{id}")
    ResponseEntity<MensagemSucesso> deletar(@PathVariable UUID id){

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
