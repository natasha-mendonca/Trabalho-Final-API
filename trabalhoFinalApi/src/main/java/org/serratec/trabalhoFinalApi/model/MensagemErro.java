package org.serratec.trabalhoFinalApi.model;

import java.time.LocalDateTime;

public record MensagemErro(String mensagem, LocalDateTime data) {
}
