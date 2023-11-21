package com.globalsolution.mentessolidarias.controller.usuario.dto;

import com.globalsolution.mentessolidarias.entities.enuns.Escolaridade;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroEscolaridade(
        @NotNull
        Escolaridade escolaridade
) {
}
