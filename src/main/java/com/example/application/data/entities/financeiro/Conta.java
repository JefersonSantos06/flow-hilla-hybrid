package com.example.application.data.entities.financeiro;

import com.example.application.data.entities.AbstractEntity;
import com.example.application.data.entities.geral.Usuario;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "conta", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"usuario_id", "nome"}, name = "uk_conta_usuario_nome")
})
public class Conta extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, columnDefinition = "DECIMAL(12,2) CHECK (saldo >= 0)")
    @Digits(integer = 10, fraction = 2)
    @DecimalMin(value = "0.0", inclusive = true)
    private BigDecimal saldo = BigDecimal.ZERO;

    @OneToMany(mappedBy = "conta", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Movimentacao> movimentacoes;

    @OneToMany(mappedBy = "conta", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Cartao> cartoes;

    public Usuario getUsuario() {
        return usuario;
    }

    public Conta setUsuario(final Usuario usuario) {
        this.usuario = usuario;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Conta setNome(final String nome) {
        this.nome = nome;
        return this;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public Conta setSaldo(final BigDecimal saldo) {
        this.saldo = saldo;
        return this;
    }

    public List<Movimentacao> getMovimentacoes() {
        return movimentacoes;
    }

    public Conta setMovimentacoes(final List<Movimentacao> movimentacoes) {
        this.movimentacoes = movimentacoes;
        return this;
    }

    public List<Cartao> getCartoes() {
        return cartoes;
    }

    public Conta setCartoes(final List<Cartao> cartoes) {
        this.cartoes = cartoes;
        return this;
    }
}
