package com.globalsolution.mentessolidarias.controller.usuario.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.globalsolution.mentessolidarias.entities.endereco.DTO.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DadosCadastroUsuario(
        @NotNull
        Long cpf,
        @NotBlank
        String nome,
        @NotBlank
        String genero,
        @NotNull
        Long telefone,
        @NotNull
        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate dtNasc,
        @NotNull
        Long idEscolaridade,
        @NotNull
        Long idTipoUsuario,
        @Email
        String email,
        @NotBlank
        String senha,
        @NotNull
        @Valid
        DadosEndereco endereco
) {
}
