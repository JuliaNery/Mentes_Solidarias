package com.globalsolution.mentessolidarias.controller.usuario.validacao;

import com.globalsolution.mentessolidarias.controller.usuario.dto.DadosCadastroPaciente;
import com.globalsolution.mentessolidarias.controller.usuario.dto.DadosDetalhamentoPaciente;
import com.globalsolution.mentessolidarias.entities.usuario.paciente.PacienteEntity;
import com.globalsolution.mentessolidarias.repositories.usuario.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidacaoPaciente {
    @Autowired
    ValidacaoUsuario validacaoUsuario;
    @Autowired
    PacienteRepository pacienteRepository;

    public DadosDetalhamentoPaciente cadastrar(DadosCadastroPaciente dados){
        var dto = dados.dadosCadastroUsuario();
        var usuario = validacaoUsuario.cadastrar(dto);

        var paciente = PacienteEntity.builder()
                .cpf(usuario.cpf())
                .filhos(dados.filhos())
                .ocupacao(dados.ocupacao())
                .estadoCivil(dados.estadoCivil())
                .niss(dados.niss())
                .build();
        pacienteRepository.save(paciente);
        return new DadosDetalhamentoPaciente(usuario, paciente);
    }
}
