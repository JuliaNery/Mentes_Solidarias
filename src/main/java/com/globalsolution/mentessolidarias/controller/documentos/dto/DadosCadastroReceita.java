package com.globalsolution.mentessolidarias.controller.documentos.dto;

import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public record DadosCadastroReceita(
        @NotNull
        @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
        LocalDateTime data,

        @NotNull
        Long idConsulta
) {
}
