package com.globalsolution.mentessolidarias.controller.consulta.dto;

import com.globalsolution.mentessolidarias.entities.consulta.ProntuarioEntity;

import java.time.LocalDateTime;

public record DadosDetalhamentoProntuario (Long id, LocalDateTime data, String descricao, Long idConsulta){
    public DadosDetalhamentoProntuario(ProntuarioEntity prontuario) {
        this(prontuario.getId(), prontuario.getData(), prontuario.getDescricao(), prontuario.getConsulta().getId());
    }
}
