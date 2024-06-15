package com.example.application.data.dtos.financeiro;

import com.example.application.data.entities.financeiro.Cartao;
import jakarta.validation.constraints.Digits;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class CartaoDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 2417774625675459945L;

    private final Long id;
    private final ContaDto conta;
    private final String nome;

    @Digits(integer = 10, fraction = 2)
    private final BigDecimal limite;

    public CartaoDto(Long id, ContaDto conta, String nome, @Digits(integer = 10, fraction = 2) BigDecimal limite) {
        this.id = id;
        this.conta = conta;
        this.nome = nome;
        this.limite = limite;
    }

    public static CartaoDto fromEntity(Cartao entity) {
        return new CartaoDto(entity.getId(), ContaDto.fromEntity(entity.getConta()), entity.getNome(), entity.getLimite());
    }

    public static Cartao toEntity(final CartaoDto dto) {
        return new Cartao()
            .setId(dto.getId())
            .setConta(ContaDto.toEntity(dto.getConta()))
            .setNome(dto.getNome())
            .setLimite(dto.getLimite());
    }

    public Long getId() {
        return id;
    }

    public ContaDto getConta() {
        return conta;
    }

    public String getNome() {
        return nome;
    }

    public @Digits(integer = 10, fraction = 2) BigDecimal getLimite() {
        return limite;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (CartaoDto) obj;
        return Objects.equals(this.id, that.id) &&
               Objects.equals(this.conta, that.conta) &&
               Objects.equals(this.nome, that.nome) &&
               Objects.equals(this.limite, that.limite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, conta, nome, limite);
    }

    @Override
    public String toString() {
        return "CartaoDto[" +
               "id=" + id + ", " +
               "conta=" + conta + ", " +
               "nome=" + nome + ", " +
               "limite=" + limite + ']';
    }

}