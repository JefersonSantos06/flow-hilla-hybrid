package com.example.application.data.repositories.financeiro;

import com.example.application.data.entities.financeiro.Movimentacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Long>, JpaSpecificationExecutor<Movimentacao> {
}
