package com.example.application.data.repositories.financeiro;

import com.example.application.data.entities.financeiro.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CartaoRepository extends JpaRepository<Cartao, Long>, JpaSpecificationExecutor<Cartao> {
}
