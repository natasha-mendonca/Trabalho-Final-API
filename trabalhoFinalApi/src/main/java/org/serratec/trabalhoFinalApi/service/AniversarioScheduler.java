package org.serratec.trabalhoFinalApi.service;

import org.serratec.trabalhoFinalApi.entity.Cliente;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class AniversarioScheduler {
    private final ClienteService clienteService;
    private final EmailService emailService;

    public AniversarioScheduler(ClienteService clienteService,
                                EmailService emailService) {
        this.clienteService = clienteService;
        this.emailService = emailService;
    }

    @Scheduled(cron = "0 0 0 * * *")
    public void verificarAniversariantes() {
        LocalDate hoje = LocalDate.now();
        List<Cliente> aniversariantes = clienteService.buscarAniversariantesDoDia(hoje);

        for (Cliente cliente : aniversariantes) {
            emailService.enviarEmailAniversario(cliente.getEmail(), cliente.getNome());
        }
    }
}
