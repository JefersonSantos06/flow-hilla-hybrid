package com.example.application.data.entities.dtos;

import com.example.application.data.entities.financeiro.Movimentacao;
import com.example.application.data.entities.financeiro.TipoMovimentacao;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class MovimentacaoDto implements Serializable {

    @Serial
    private static final long serialVersionUID = -3847128961090106858L;

    private final Long id;

    @Digits(integer = 10, fraction = 2)
    private final BigDecimal valor;
    private final LocalDate data;
    private final String descricao;

    @Min(1)
    private final Integer totalParcelas;

    @Min(1)
    private final Integer parcelaAtual;
    private final TipoMovimentacao tipo;

    public MovimentacaoDto(Long id, @Digits(integer = 10, fraction = 2) BigDecimal valor, LocalDate data, String descricao, @Min(1) Integer totalParcelas, @Min(1) Integer parcelaAtual, TipoMovimentacao tipo) {
        this.id = id;
        this.valor = valor;
        this.data = data;
        this.descricao = descricao;
        this.totalParcelas = totalParcelas;
        this.parcelaAtual = parcelaAtual;
        this.tipo = tipo;
    }

    public static MovimentacaoDto fromEntity(final Movimentacao entity) {
        return new MovimentacaoDto(entity.getId(), entity.getValor(), entity.getData(), entity.getDescricao(), entity.getTotalParcelas(), entity.getParcelaAtual(), entity.getTipo());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (MovimentacaoDto) obj;
        return Objects.equals(this.id, that.id) &&
               Objects.equals(this.valor, that.valor) &&
               Objects.equals(this.data, that.data) &&
               Objects.equals(this.descricao, that.descricao) &&
               Objects.equals(this.totalParcelas, that.totalParcelas) &&
               Objects.equals(this.parcelaAtual, that.parcelaAtual) &&
               Objects.equals(this.tipo, that.tipo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, valor, data, descricao, totalParcelas, parcelaAtual, tipo);
    }

    @Override
    public String toString() {
        return "MovimentacaoDto[" +
               "id=" + id + ", " +
               "valor=" + valor + ", " +
               "data=" + data + ", " +
               "descricao=" + descricao + ", " +
               "totalParcelas=" + totalParcelas + ", " +
               "parcelaAtual=" + parcelaAtual + ", " +
               "tipo=" + tipo + ']';
    }

}