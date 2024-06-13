package com.example.application.security;

import com.example.application.data.entities.geral.Usuario;
import com.example.application.data.repositories.geral.UsuarioRepository;
import com.vaadin.flow.spring.security.AuthenticationContext;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
public class AuthenticatedUser {

    private final UsuarioRepository userRepository;
    private final AuthenticationContext authenticationContext;

    public AuthenticatedUser(AuthenticationContext authenticationContext, UsuarioRepository usuarioRepository) {
        this.userRepository = usuarioRepository;
        this.authenticationContext = authenticationContext;
    }

    @Transactional
    public Optional<Usuario> get() {
        return authenticationContext.getAuthenticatedUser(UserDetails.class)
                .map(userDetails -> userRepository.findByUsername(userDetails.getUsername()));
    }

    public void logout() {
        authenticationContext.logout();
    }

}
