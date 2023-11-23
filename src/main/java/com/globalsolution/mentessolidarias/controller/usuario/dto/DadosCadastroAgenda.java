package com.globalsolution.mentessolidarias.controller.usuario.dto;

import com.globalsolution.mentessolidarias.entities.enuns.DiaSemana;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroAgenda(
        @NotNull
        DiaSemana diaSemana,
        @NotNull
        Long cpf
) {
}
