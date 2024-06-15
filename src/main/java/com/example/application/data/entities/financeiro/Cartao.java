package com.example.application.data.entities.financeiro;

import com.example.application.data.entities.AbstractEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "cartao", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"conta_id", "nome"})
})
public class Cartao extends AbstractEntity<Cartao> {

    @ManyToOne
    @JoinColumn(name = "conta_id", nullable = false)
    private Conta conta;

    @Column(nullable = false, unique = true)
    private String nome;

    @Column(nullable = false, columnDefinition = "DECIMAL(12,2) CHECK (limite >= 0)")
    @Digits(integer = 10, fraction = 2)
    @DecimalMin(value = "0.0", inclusive = true)
    private BigDecimal limite = BigDecimal.ZERO;

    @OneToMany(mappedBy = "cartao", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Movimentacao> movimentacoes;

    public Conta getConta() {
        return conta;
    }

    public Cartao setConta(final Conta conta) {
        this.conta = conta;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Cartao setNome(final String nome) {
        this.nome = nome;
        return this;
    }

    public BigDecimal getLimite() {
        return limite;
    }

    public Cartao setLimite(final BigDecimal limite) {
        this.limite = limite;
        return this;
    }

    public List<Movimentacao> getMovimentacoes() {
        return movimentacoes;
    }

    public Cartao setMovimentacoes(final List<Movimentacao> movimentacoes) {
        this.movimentacoes = movimentacoes;
        return this;
    }
}
