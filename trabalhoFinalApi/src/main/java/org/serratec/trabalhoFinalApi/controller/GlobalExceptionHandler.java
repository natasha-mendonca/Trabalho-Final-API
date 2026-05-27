package org.serratec.trabalhoFinalApi.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.serratec.trabalhoFinalApi.exception.EcommerceException;
import org.serratec.trabalhoFinalApi.model.MensagemErro;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EcommerceException.class)
    public ResponseEntity<Object> handleEcommerceException(EcommerceException ex) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status",ex.getStatus().value());
        body.put("codigo", ex.getCodigo());
        body.put("mensagem", ex.getMessage());

        return new ResponseEntity<>(body, ex.getStatus());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", HttpStatus.BAD_REQUEST.value());
        body.put("codigo", "SYS-001");

        String mensagemErro = ex.getBindingResult().getAllErrors().get(0).getDefaultMessage();
        body.put("mensagem", mensagemErro);

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGenericException(Exception ex) {
        ex.printStackTrace();
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        body.put("mensagem", "Ocorreu um erro interno inesperado.");

        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<MensagemErro> handleIncompatibilidadeDeTipos(MethodArgumentTypeMismatchException ex){

        if(ex.getRequiredType() == UUID.class){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MensagemErro("UUID inválido. Siga o padrão UUID: 00000000-0000-0000-0000-000000000000", LocalDateTime.now()));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MensagemErro("Valor informado inválido.", LocalDateTime.now()));
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Map<String, Object>> handleHttpMessageNotReadable(
            HttpMessageNotReadableException ex, HttpServletRequest request) {

        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", HttpStatus.BAD_REQUEST.value());

        String mensagemOriginal = ex.getMessage();
        if (mensagemOriginal != null && mensagemOriginal.contains("UUID")) {
            body.put("message", "Formato de UUID inválido. O ID enviado nao possui o padrão de 36 caracteres. Verifice todos os campos novamente antes de enviar a requisicao");
        } else {
            body.put("message", "Erro na leitura do corpo da requisição (JSON malformado).");
        }
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

}