package com.globalsolution.mentessolidarias.controller.consulta.dto;

import com.globalsolution.mentessolidarias.entities.consulta.ConsultaEntity;

import java.time.LocalDateTime;

public record DadosDetalhamentoConsulta(Long id, Long cpfPaciente, Long cpfProfissional, LocalDateTime data, String link) {

    public DadosDetalhamentoConsulta(ConsultaEntity consulta) {
        this(consulta.getId(), consulta.getPaciente().getCpf(),consulta.getProfissional().getCpf(), consulta.getData(), consulta.getLink());
    }
}
