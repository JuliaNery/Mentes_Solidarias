package com.globalsolution.mentessolidarias.controller.usuario.dto;


import com.globalsolution.mentessolidarias.controller.usuario.dto.DadosDetalhamentoUsuario;
import com.globalsolution.mentessolidarias.entities.enuns.EstadoCivil;
import com.globalsolution.mentessolidarias.entities.usuario.UsuarioEntity;
import com.globalsolution.mentessolidarias.entities.usuario.paciente.PacienteEntity;

public record DadosDetalhamentoPaciente(
        DadosDetalhamentoUsuario dadosDetalhamentoUsuario,
        Integer filhos,
        String ocupacao,
        EstadoCivil estadoCivil,
        Long niss

) {
    public DadosDetalhamentoPaciente(DadosDetalhamentoUsuario usuario,PacienteEntity paciente) {
        this(usuario,
                paciente.getFilhos(),
                paciente.getOcupacao(),
                paciente.getEstadoCivil(),
                paciente.getNiss());
    }

}
