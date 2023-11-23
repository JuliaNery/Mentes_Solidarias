package com.globalsolution.mentessolidarias.controller.usuario.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalTime;

public record DadosCadastroHorario(
        @NotNull
        LocalTime horario,
        @NotNull
        Long idAgenda
) {
}
