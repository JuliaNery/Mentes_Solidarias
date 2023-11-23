package com.globalsolution.mentessolidarias.controller.usuario.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosLogin(
        @NotNull
        Long cpf,
        @NotBlank
        String senha
) {
}
