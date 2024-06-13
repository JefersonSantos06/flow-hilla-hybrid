package com.example.application.data.repositories.financeiro;

import com.example.application.data.entities.financeiro.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long>, JpaSpecificationExecutor<Conta> {
}
