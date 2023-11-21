package com.globalsolution.mentessolidarias.controller.usuario.dto;

import com.globalsolution.mentessolidarias.entities.enuns.TipoUsuario;
import com.globalsolution.mentessolidarias.entities.usuario.TipoUsuarioEntity;

public record DadosDetalhamentoTipoUsuario(Long id, TipoUsuario tipoUsuario) {
    public DadosDetalhamentoTipoUsuario(TipoUsuarioEntity tipoUsuario) {
        this(tipoUsuario.getId(), tipoUsuario.getTipoUsuario());
    }
}
