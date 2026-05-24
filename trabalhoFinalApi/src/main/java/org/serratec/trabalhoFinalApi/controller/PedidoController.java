package org.serratec.trabalhoFinalApi.controller;

    // TIRAR O COMENTARIO GERAL QUANDO O SERVICE DE PEDIDO ESTIVER FUNCIONANDO


//import jakarta.validation.Valid;
//import org.serratec.trabalhoFinalApi.model.PedidoBuscar;
//import org.serratec.trabalhoFinalApi.model.PedidoCriar;
//import org.serratec.trabalhoFinalApi.service.PedidoService;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.UUID;
//
//@RestController
//@RequestMapping("/pedido")
//public class PedidoController {
//
//    PedidoService pedidoService;
//
//    public PedidoController(PedidoService pedidoService) {
//        this.pedidoService = pedidoService;
//    }
//
//    @PostMapping
//    ResponseEntity<Void> criar (@RequestBody @Valid PedidoCriar pedidoCriar){
//
//        this.pedidoService.inserirPedido(pedidoCriar);
//        return  ResponseEntity.ok().build();
//    }
//
//    @GetMapping("/{id}")
//    ResponseEntity<List<PedidoBuscar>> listarPedidos(@PathVariable UUID id){
//        return ResponseEntity.ok().body(this.pedidoService.listarPedidos(id));
//    }
//
//
//
////    @GetMapping
//    //ADICIONAR A FUNCIONALIADE PAGABLE
////    ResponseEntity<PedidoBuscar> buscar(@RequestParam (required = false)UUID id){
////
////        return  ;
////    }
//
//
//}
