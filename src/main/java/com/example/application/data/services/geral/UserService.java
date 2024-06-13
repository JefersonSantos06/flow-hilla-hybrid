package com.example.application.data.services.geral;

import com.example.application.data.entities.geral.Usuario;
import com.example.application.data.repositories.geral.UsuarioRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UsuarioRepository repository;

    public UserService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public Optional<Usuario> get(Long id) {
        return repository.findById(id);
    }

    public Usuario update(Usuario entity) {
        return repository.save(entity);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Page<Usuario> list(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Page<Usuario> list(Pageable pageable, Specification<Usuario> filter) {
        return repository.findAll(filter, pageable);
    }

    public int count() {
        return (int) repository.count();
    }

}
