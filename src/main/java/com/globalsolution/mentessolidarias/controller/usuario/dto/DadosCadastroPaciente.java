package com.globalsolution.mentessolidarias.controller.usuario.dto;

import com.globalsolution.mentessolidarias.controller.usuario.dto.DadosCadastroUsuario;
import com.globalsolution.mentessolidarias.entities.enuns.EstadoCivil;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroPaciente(
        @NotNull
        DadosCadastroUsuario dadosCadastroUsuario,
        @NotNull
        Integer filhos,
        @NotBlank
        String ocupacao,
        @NotNull
        EstadoCivil estadoCivil,
        @NotNull
        Long niss
) {
}
