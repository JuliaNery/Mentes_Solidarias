package com.globalsolution.mentessolidarias.controller.usuario.dto;

import com.globalsolution.mentessolidarias.entities.enuns.DiaSemana;
import jakarta.validation.constraints.NotNull;

import java.time.LocalTime;

public record DadosCadastroAgenda(
        @NotNull
        DiaSemana diaSemana,

        @NotNull
        LocalTime horario,
        @NotNull
        Long cpf
) {
}
