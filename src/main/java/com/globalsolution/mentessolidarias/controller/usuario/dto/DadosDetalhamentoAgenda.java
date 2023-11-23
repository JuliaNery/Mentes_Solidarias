package com.globalsolution.mentessolidarias.controller.usuario.dto;

import com.globalsolution.mentessolidarias.entities.enuns.DiaSemana;
import com.globalsolution.mentessolidarias.entities.usuario.agenda.AgendaEntity;

import java.time.LocalTime;
import java.util.List;

public record DadosDetalhamentoAgenda(Long id, DiaSemana diaSemana, LocalTime horario, Long cpf) {

    public DadosDetalhamentoAgenda(AgendaEntity agenda) {
        this(agenda.getId(), agenda.getDiaSemana(), agenda.getHorario(),agenda.getProfissional().getCpf());
    }
}
