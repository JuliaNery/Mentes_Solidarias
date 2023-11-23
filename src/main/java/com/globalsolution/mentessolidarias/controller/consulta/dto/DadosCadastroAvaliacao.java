package com.globalsolution.mentessolidarias.controller.consulta.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroAvaliacao(
        @NotNull
        Short nota,
        @NotBlank
        String avaliacao,
        @NotNull
        Long idConsulta) {
}
