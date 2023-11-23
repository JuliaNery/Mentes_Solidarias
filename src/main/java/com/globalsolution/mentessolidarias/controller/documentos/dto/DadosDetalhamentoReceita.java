package com.globalsolution.mentessolidarias.controller.documentos.dto;

import com.globalsolution.mentessolidarias.entities.documentos.receita.ReceitaEntity;

import java.time.LocalDateTime;

public record DadosDetalhamentoReceita(Long id, LocalDateTime data, Long idConsulta) {
    public DadosDetalhamentoReceita(ReceitaEntity receita) {
        this(receita.getId(), receita.getData(), receita.getConsulta().getId());
    }
}
