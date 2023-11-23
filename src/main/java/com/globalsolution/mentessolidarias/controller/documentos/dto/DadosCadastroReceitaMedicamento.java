package com.globalsolution.mentessolidarias.controller.documentos.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroReceitaMedicamento(
        @NotBlank
        String descricao,
        @NotBlank
        String frequenciaAdmin,
        @NotBlank
        String duracaoAdmin,
        @NotNull
        Long idReceita,
        @NotNull
        Long idMedicamento
) {
}
