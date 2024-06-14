package com.example.application.data.entities.dtos;

import com.example.application.data.entities.financeiro.Cartao;

import java.util.List;
import java.util.stream.Collectors;

public class CartaoWithMovimentacoesDto extends CartaoDto {

    private final List<MovimentacaoDto> movimentacoes;

    public CartaoWithMovimentacoesDto(CartaoDto cartaoDto, List<MovimentacaoDto> movimentacoes) {
        super(cartaoDto.getId(), cartaoDto.getConta(), cartaoDto.getNome(), cartaoDto.getLimite());
        this.movimentacoes = movimentacoes;
    }

    public static CartaoWithMovimentacoesDto fromEntity(Cartao entity) {
        return new CartaoWithMovimentacoesDto(
            CartaoDto.fromEntity(entity),
            entity.getMovimentacoes().stream().map(MovimentacaoDto::fromEntity).collect(Collectors.toList())
        );
    }

    public List<MovimentacaoDto> getMovimentacoes() {
        return movimentacoes;
    }
}