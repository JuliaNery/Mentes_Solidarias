package com.globalsolution.mentessolidarias.controller.usuario.agenda;

import com.globalsolution.mentessolidarias.controller.usuario.dto.DadosCadastroAgenda;
import com.globalsolution.mentessolidarias.controller.usuario.dto.DadosCadastroHorario;
import com.globalsolution.mentessolidarias.controller.usuario.dto.DadosDetalhamentoAgenda;
import com.globalsolution.mentessolidarias.controller.usuario.dto.DadosDetalhamentoHorario;
import com.globalsolution.mentessolidarias.entities.usuario.agenda.AgendaEntity;
import com.globalsolution.mentessolidarias.entities.usuario.agenda.HorarioEntity;
import com.globalsolution.mentessolidarias.repositories.usuario.AgendaRepository;
import com.globalsolution.mentessolidarias.repositories.usuario.HorarioRepository;
import com.globalsolution.mentessolidarias.repositories.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ValidacaoHorario {
    @Autowired
    private HorarioRepository horarioRepository;
    @Autowired
    private AgendaRepository agendaRepository;

    public List<DadosDetalhamentoHorario> cadastrar(List<DadosCadastroHorario> dados){

        List<HorarioEntity> horarios = new ArrayList<>();
        for (DadosCadastroHorario dado : dados){
        var agenda = agendaRepository.getReferenceById(dado.idAgenda());
            horarios.add(HorarioEntity.builder()
                    .horario(dado.horario())
                    .agenda(agenda)
                    .build());
        }
        List<DadosDetalhamentoHorario> dto = new ArrayList<>();
        for(HorarioEntity horario : horarios){
            horarioRepository.save(horario);
            dto.add(new DadosDetalhamentoHorario(horario));
        }

        return dto;
    }
}
