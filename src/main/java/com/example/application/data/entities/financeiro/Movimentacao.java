package com.example.application.data.entities.financeiro;

import com.example.application.data.entities.AbstractEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import org.hibernate.annotations.Check;

import java.math.BigDecimal;
import java.time.LocalDate;


@Entity
@Table(name = "movimentacao")
@Check(constraints = "conta_id IS NOT NULL OR cartao_id IS NOT NULL")
public class Movimentacao extends AbstractEntity<Movimentacao> {

    @ManyToOne
    @JoinColumn(name = "conta_id", nullable = true)
    private Conta conta;

    @ManyToOne
    @JoinColumn(name = "cartao_id", nullable = true)
    private Cartao cartao;

    @Column(nullable = false, columnDefinition = "DECIMAL(12,2) CHECK (valor >= 0)")
    @Digits(integer = 10, fraction = 2)
    @DecimalMin(value = "0.0", inclusive = true)
    private BigDecimal valor = BigDecimal.ZERO;

    @Column(nullable = false)
    private LocalDate data;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    @Min(1)
    private Integer totalParcelas = 1;

    @Column(nullable = false)
    @Min(1)
    private Integer parcelaAtual = 1;

    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false)
    private TipoMovimentacao tipo;

    public Conta getConta() {
        return conta;
    }

    public Movimentacao setConta(final Conta conta) {
        this.conta = conta;
        return this;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public Movimentacao setCartao(final Cartao cartao) {
        this.cartao = cartao;
        return this;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Movimentacao setValor(final BigDecimal valor) {
        this.valor = valor;
        return this;
    }

    public LocalDate getData() {
        return data;
    }

    public Movimentacao setData(final LocalDate data) {
        this.data = data;
        return this;
    }

    public String getDescricao() {
        return descricao;
    }

    public Movimentacao setDescricao(final String descricao) {
        this.descricao = descricao;
        return this;
    }

    public Integer getTotalParcelas() {
        return totalParcelas;
    }

    public Movimentacao setTotalParcelas(final Integer totalParcelas) {
        this.totalParcelas = totalParcelas;
        return this;
    }

    public Integer getParcelaAtual() {
        return parcelaAtual;
    }

    public Movimentacao setParcelaAtual(final Integer parcelaAtual) {
        this.parcelaAtual = parcelaAtual;
        return this;
    }

    public TipoMovimentacao getTipo() {
        return tipo;
    }

    public Movimentacao setTipo(final TipoMovimentacao tipo) {
        this.tipo = tipo;
        return this;
    }
}
