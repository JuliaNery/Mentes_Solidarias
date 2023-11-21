package com.globalsolution.mentessolidarias.controller.usuario.dto;

import com.globalsolution.mentessolidarias.entities.enuns.Escolaridade;
import com.globalsolution.mentessolidarias.entities.usuario.EscolaridadeEntity;

public record DadosDetalhamentoEscolaridade(Long id, Escolaridade escolaridade) {
    public DadosDetalhamentoEscolaridade(EscolaridadeEntity escolaridade) {
        this(escolaridade.getId(), escolaridade.getEscolaridade());
    }
}
