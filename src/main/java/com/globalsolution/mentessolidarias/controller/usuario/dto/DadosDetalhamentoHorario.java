package com.globalsolution.mentessolidarias.controller.usuario.dto;

import com.globalsolution.mentessolidarias.entities.usuario.agenda.HorarioEntity;

import java.time.LocalTime;

public record DadosDetalhamentoHorario(Long id, LocalTime horario, Long idAgenda) {
    public DadosDetalhamentoHorario(HorarioEntity horario) {
        this(horario.getId(), horario.getHorario(),horario.getAgenda().getId());
    }
}
