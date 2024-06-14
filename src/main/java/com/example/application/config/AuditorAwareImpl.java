package com.example.application.config;

import com.example.application.data.repositories.geral.UsuarioRepository;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AuditorAwareImpl implements AuditorAware<Long> {

    private final UsuarioRepository userRepository;

    public AuditorAwareImpl(final UsuarioRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<Long> getCurrentAuditor() {
        if (SecurityContextHolder.getContext().getAuthentication() == null) {
            return Optional.empty();
        }
        final var userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        final var usuario = userRepository.findByUsername(userDetails.getUsername());
        return Optional.ofNullable(usuario != null ? usuario.getId() : null);
    }
}