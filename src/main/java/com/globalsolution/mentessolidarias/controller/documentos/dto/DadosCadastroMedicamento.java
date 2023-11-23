package com.globalsolution.mentessolidarias.controller.documentos.dto;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroMedicamento(
        @NotBlank
        String nome,
        @NotBlank
        String fabricante,
        @NotBlank
        String viaAdministracao,
        @NotBlank
        String principioAtivo

) {
}
