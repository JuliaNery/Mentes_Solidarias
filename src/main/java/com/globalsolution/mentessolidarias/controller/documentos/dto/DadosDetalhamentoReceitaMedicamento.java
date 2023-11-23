package com.globalsolution.mentessolidarias.controller.documentos.dto;

import com.globalsolution.mentessolidarias.entities.documentos.receita.ReceitaMedicamentoEntity;

import java.util.List;

public record DadosDetalhamentoReceitaMedicamento(
        Long id,
        String descricao,
        String frequenciaAdmin,
        String duracaoAdmin,
        Long idReceita,
        Long idMedicamento
        ) {
    public DadosDetalhamentoReceitaMedicamento(ReceitaMedicamentoEntity receitaMedicamento) {
        this(receitaMedicamento.getId(), receitaMedicamento.getDescricao(), receitaMedicamento.getFrequenciaAdmin(), receitaMedicamento.getDuracaoAdmin(), receitaMedicamento.getReceita().getId(),receitaMedicamento.getMedicamento().getId());
    }


}
