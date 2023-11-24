package com.globalsolution.mentessolidarias.controller.consulta.validacao;

import com.globalsolution.mentessolidarias.controller.consulta.dto.DadosCadastroConsulta;
import com.globalsolution.mentessolidarias.controller.consulta.dto.DadosDetalhamentoConsulta;
import com.globalsolution.mentessolidarias.entities.consulta.ConsultaEntity;
import com.globalsolution.mentessolidarias.entities.enuns.TipoUsuario;
import com.globalsolution.mentessolidarias.entities.usuario.profissional.ProfissionalEntity;
import com.globalsolution.mentessolidarias.repositories.consulta.ConsultaRepository;
import com.globalsolution.mentessolidarias.repositories.usuario.AgendaRepository;
import com.globalsolution.mentessolidarias.repositories.usuario.PacienteRepository;
import com.globalsolution.mentessolidarias.repositories.usuario.ProfissionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ValidacaoConsulta {
    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private ProfissionalRepository profissionalRepository;


    @Autowired
    private AgendaRepository agendaRepository;


    public DadosDetalhamentoConsulta cadastrar(DadosCadastroConsulta dados){
        var paciente = pacienteRepository.getReferenceById(dados.cpfPaciente());
        var profissional = escolherMedico(dados.data(), dados.especialidade(), dados.genero());
        var consulta = ConsultaEntity.builder()
                .paciente(paciente)
                .profissional(profissional)
                .data(dados.data())
                .link(dados.link())
                .build();
        consultaRepository.save(consulta);
        return new DadosDetalhamentoConsulta(consulta);
    }

    private ProfissionalEntity escolherMedico(LocalDateTime data, TipoUsuario especialidade, String genero) {


        var profissional = profissionalRepository.getProfissionalLivre(data, especialidade, genero);

        return profissional;
    }
}
