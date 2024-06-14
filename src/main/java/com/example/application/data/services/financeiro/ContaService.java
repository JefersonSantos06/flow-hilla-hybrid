package com.example.application.data.services.financeiro;

import com.example.application.config.security.AuthenticatedUser;
import com.example.application.data.entities.financeiro.Conta;
import com.example.application.data.repositories.financeiro.ContaRepository;
import jakarta.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@PermitAll
public class ContaService {

    private final ContaRepository contaRepository;
    private final AuthenticatedUser authenticatedUser;

    @Autowired
    public ContaService(final ContaRepository contaRepository, final AuthenticatedUser authenticatedUser) {
        this.contaRepository = contaRepository;
        this.authenticatedUser = authenticatedUser;
    }

    public Page<Conta> list(final Pageable pageable) {
        final var currentUser = authenticatedUser.get().orElseThrow(() -> new AccessDeniedException("User not authenticated"));
        if (currentUser.isAdmin()) {
            return contaRepository.findAll(pageable);
        } else {
            return contaRepository.findByUsuarioId(currentUser.getId(), pageable);
        }
    }

    public Optional<Conta> findById(final Long id) {
        final var currentUser = authenticatedUser.get().orElseThrow(() -> new AccessDeniedException("User not authenticated"));
        final var conta = contaRepository.findById(id);

        if (conta.isPresent() && (conta.get().getUsuario().getId().equals(currentUser.getId()) || currentUser.isAdmin())) {
            return conta;
        }
        throw new AccessDeniedException("Access denied");
    }

    public Conta save(final Conta conta) {
        final var currentUser = authenticatedUser.get().orElseThrow(() -> new AccessDeniedException("User not authenticated"));
        if (conta.getUsuario().getId().equals(currentUser.getId()) || currentUser.isAdmin()) {
            return contaRepository.save(conta);
        }
        throw new AccessDeniedException("Access denied");
    }

    public void delete(final Long id) {
        final var currentUser = authenticatedUser.get().orElseThrow(() -> new AccessDeniedException("User not authenticated"));
        final var conta = contaRepository.findById(id);
        if (conta.isPresent() && (conta.get().getUsuario().getId().equals(currentUser.getId()) || currentUser.isAdmin())) {
            contaRepository.deleteById(id);
        }
        throw new AccessDeniedException("Access denied");
    }
}