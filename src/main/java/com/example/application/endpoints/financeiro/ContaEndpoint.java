package com.example.application.endpoints.financeiro;

import com.example.application.data.dtos.financeiro.ContaDto;
import com.example.application.data.services.financeiro.ContaService;
import com.vaadin.hilla.BrowserCallable;
import jakarta.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

@PermitAll
@BrowserCallable
public class ContaEndpoint {

    private final ContaService contaService;

    @Autowired
    public ContaEndpoint(final ContaService contaService) {
        this.contaService = contaService;
    }

    public Page<ContaDto> list(final Pageable pageable) {
        return contaService.list(pageable).map(ContaDto::fromEntity);
    }

    public Optional<ContaDto> findById(final Long id) {
        return contaService.findById(id).map(ContaDto::fromEntity);
    }

    public ContaDto save(final ContaDto contaDto) {
        final var conta = ContaDto.toEntity(contaDto);
        return ContaDto.fromEntity(contaService.save(conta));
    }

    public void delete(final Long id) {
        contaService.delete(id);
    }
}
