package org.serratec.trabalhoFinalApi.entity;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AuditorAwareImpl implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor(){
        String usuarioAtual = System.getProperty("user.name");
        return Optional.of(usuarioAtual);
    }
}
