package org.serratec.trabalhoFinalApi.service;

import jakarta.mail.Session;
import org.serratec.trabalhoFinalApi.entity.Pedido;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import java.util.Properties;

@Service
public class EmailService {

    private JavaMailSender javaMailSender;
    private String from;

    public EmailService(JavaMailSender javaMailSender, @Value("${spring.mail.username}") String from) {
        this.javaMailSender = javaMailSender;
        this.from = from;
    }

    public void enviarEmailCadastro(String to){
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom(from);
        message.setTo(to);
        message.setSubject("Seja bem-vindo!");
        message.setText("É um prazer ter você conosco! Seu cadastro foi realizado com sucesso!");

        this.javaMailSender.send(message);
    }

    public void enviarEmailAlteracao(String to){
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom(from);
        message.setTo(to);
        message.setSubject("Alteração de dados");
        message.setText("Alteração de dados feita com sucesso! Caso não tenha sido você, entre em contato com nossa equipe: (21)99999-9999");

        this.javaMailSender.send(message);
    }

    public void enviarEmailPedidoAprovado(String to, Pedido pedido){
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom(from);
        message.setTo(to);
        message.setSubject("Pedido Aprovado");
        message.setText("Seu pedido foi aprovado com sucesso!" +
                "\nNúmero do pedido: " + pedido.getId());

        this.javaMailSender.send(message);
    }

    public void enviarEmailPedidoAtualizado(String to, Pedido pedido){
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom(from);
        message.setTo(to);
        message.setSubject("Pedido Atualizado");
        message.setText("Seu pedido foi atualizado com sucesso!" +
                "\nNúmero do pedido: " + pedido.getId());

        this.javaMailSender.send(message);
    }

    public void enviarEmailPedidoCancelado(String to, Pedido pedido){
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom(from);
        message.setTo(to);
        message.setSubject("Pedido Cancelado");
        message.setText("Seu pedido com o número: " + pedido.getId() + "foi cancelado!");

        this.javaMailSender.send(message);
    }
}