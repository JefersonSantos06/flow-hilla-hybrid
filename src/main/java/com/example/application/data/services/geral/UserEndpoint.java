package com.example.application.data.services.geral;

import com.example.application.data.entities.geral.Usuario;
import com.example.application.security.AuthenticatedUser;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.hilla.Endpoint;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@Endpoint
@AnonymousAllowed
public class UserEndpoint {

    @Autowired
    private AuthenticatedUser authenticatedUser;

    public Optional<Usuario> getAuthenticatedUser() {
        return authenticatedUser.get();
    }
}
