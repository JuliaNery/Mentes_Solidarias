package com.globalsolution.mentessolidarias.controller.consulta.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.globalsolution.mentessolidarias.entities.enuns.TipoUsuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosCadastroConsulta(
        @NotNull
        Long cpfPaciente,

        Long cpfProfissional,
        @NotNull
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
        LocalDateTime data,
        @NotNull
        TipoUsuario especialidade,
        @NotBlank
        String genero,
        String link
) {
}
