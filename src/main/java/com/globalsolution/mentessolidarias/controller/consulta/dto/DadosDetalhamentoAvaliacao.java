package com.globalsolution.mentessolidarias.controller.consulta.dto;

import com.globalsolution.mentessolidarias.entities.consulta.AvaliacaoEntity;
import com.globalsolution.mentessolidarias.entities.consulta.ConsultaEntity;

public record DadosDetalhamentoAvaliacao(Long id, Short nota, String avaliacao, Long idConsulta) {

    public DadosDetalhamentoAvaliacao(AvaliacaoEntity avaliacao) {
        this(avaliacao.getId(), avaliacao.getNota(), avaliacao.getAvaliacao(), avaliacao.getConsulta().getId());
    }
}
