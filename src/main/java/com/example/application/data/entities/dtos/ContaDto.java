package com.example.application.data.entities.dtos;

import com.example.application.data.entities.financeiro.Conta;
import jakarta.validation.constraints.Digits;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class ContaDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 8665694710847399243L;

    private final Long id;
    private final UsuarioDto usuario;
    private final String nome;

    @Digits(integer = 10, fraction = 2)
    private final BigDecimal saldo;

    public ContaDto(Long id, UsuarioDto usuario, String nome, @Digits(integer = 10, fraction = 2) BigDecimal saldo) {
        this.id = id;
        this.usuario = usuario;
        this.nome = nome;
        this.saldo = saldo;
    }

    public static ContaDto fromEntity(Conta entity) {
        return new ContaDto(entity.getId(), UsuarioDto.fromEntity(entity.getUsuario()), entity.getNome(), entity.getSaldo());
    }

    public Long getId() {
        return id;
    }

    public UsuarioDto getUsuario() {
        return usuario;
    }

    public String getNome() {
        return nome;
    }

    public @Digits(integer = 10, fraction = 2) BigDecimal getSaldo() {
        return saldo;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (ContaDto) obj;
        return Objects.equals(this.id, that.id) &&
               Objects.equals(this.usuario, that.usuario) &&
               Objects.equals(this.nome, that.nome) &&
               Objects.equals(this.saldo, that.saldo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, usuario, nome, saldo);
    }

    @Override
    public String toString() {
        return "ContaDto[" +
               "id=" + id + ", " +
               "usuario=" + usuario + ", " +
               "nome=" + nome + ", " +
               "saldo=" + saldo + ']';
    }

}