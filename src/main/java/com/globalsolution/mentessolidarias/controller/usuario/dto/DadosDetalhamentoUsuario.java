package com.globalsolution.mentessolidarias.controller.usuario.dto;

import com.globalsolution.mentessolidarias.entities.endereco.Endereco;
import com.globalsolution.mentessolidarias.entities.usuario.UsuarioEntity;

import java.time.LocalDate;

public record DadosDetalhamentoUsuario(
        Long cpf,
        String nome,
        String genero,
        Long telefone,
        LocalDate dtNasc,
        Long idEscolaridade,
        Long idTipoUsuario,
        String email,
        String senha,
        Endereco endereco
) {
    public DadosDetalhamentoUsuario(UsuarioEntity usuario) {
        this(usuario.getCpf(), usuario.getNome(), usuario.getGenero(), usuario.getTelefone(), usuario.getDtNasc(), usuario.getEscolaridade().getId(),usuario.getTipoUsuario().getId(), usuario.getEmail(), usuario.getSenha(), usuario.getEndereco());
    }
}
