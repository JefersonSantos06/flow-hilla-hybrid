package com.example.application.data.dtos.financeiro;

import com.example.application.data.entities.financeiro.Conta;

import java.util.List;
import java.util.stream.Collectors;

public class ContaWithMovimentacoesDto extends ContaDto {

    private final List<MovimentacaoDto> movimentacoes;

    public ContaWithMovimentacoesDto(ContaDto contaDto, List<MovimentacaoDto> movimentacoes) {
        super(contaDto.getId(), contaDto.getUsuario(), contaDto.getNome(), contaDto.getSaldo());
        this.movimentacoes = movimentacoes;
    }

    public static ContaWithMovimentacoesDto fromEntity(Conta entity) {
        return new ContaWithMovimentacoesDto(
            ContaDto.fromEntity(entity),
            entity.getMovimentacoes().stream().map(MovimentacaoDto::fromEntity).collect(Collectors.toList())
        );
    }

    public static Conta toEntity(final ContaWithMovimentacoesDto dto) {
        return ContaDto.toEntity(dto)
            .setMovimentacoes(dto.getMovimentacoes().stream().map(MovimentacaoDto::toEntity).collect(Collectors.toList()));
    }

    public List<MovimentacaoDto> getMovimentacoes() {
        return movimentacoes;
    }
}
