package com.globalsolution.mentessolidarias.controller.usuario.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroProfissional(

        @NotNull
        DadosCadastroUsuario dadosCadastroUsuario,
        @NotNull
        Long certificacao,
        @NotBlank
        String formacao,
        Long cnpj
) {
}
