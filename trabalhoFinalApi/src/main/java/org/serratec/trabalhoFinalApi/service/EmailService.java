package org.serratec.trabalhoFinalApi.service;

import jakarta.mail.Session;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import java.util.Properties;

@Service
public class EmailService {

    private JavaMailSender javaMailSender;
    private String from;
    private Session session;

    public EmailService(JavaMailSender javaMailSender, @Value("${spring.mail.username}") String from, @Value("${spring.mail.host}") String host, @Value("${spring.mail.port}") String port, @Value("${spring.mail.username}") String username, @Value("${spring.mail.password}") String password) {
        this.javaMailSender = javaMailSender;
        this.from = from;

        Properties props = new Properties();
        props.put("spring.mail.host", host);
        props.put("spring.mail.port", port);
        props.put("spring.mail.username", username);
        props.put("spring.mail.password", password);
        session = Session.getInstance(props);
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
}