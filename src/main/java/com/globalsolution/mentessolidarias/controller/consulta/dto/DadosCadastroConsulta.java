package com.globalsolution.mentessolidarias.controller.consulta.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosCadastroConsulta(
        @NotNull
        Long cpfPaciente,

        Long cpfProfissional,
        @NotNull
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
        LocalDateTime data,
        String link
) {
}
