package com.globalsolution.mentessolidarias.controller.usuario.dto;

import com.globalsolution.mentessolidarias.entities.usuario.profissional.ProfissionalEntity;

public record DadosDetalhamentoProfissional(
        DadosDetalhamentoUsuario dadosDetalhamentoUsuario,
        Long certificacao,
        String formacao,
        Long cnpj
) {
    public DadosDetalhamentoProfissional(DadosDetalhamentoUsuario usuario,ProfissionalEntity profissional) {
        this(usuario,
        profissional.getCertificacao(), profissional.getFormacao(), profissional.getCnpj());
    }
}
