package com.globalsolution.mentessolidarias.controller.consulta.validacao;

import com.globalsolution.mentessolidarias.controller.usuario.dto.DadosCadastroAgenda;
import com.globalsolution.mentessolidarias.controller.usuario.dto.DadosCadastroUsuario;
import com.globalsolution.mentessolidarias.controller.usuario.dto.DadosDetalhamentoAgenda;
import com.globalsolution.mentessolidarias.controller.usuario.dto.DadosDetalhamentoUsuario;
import com.globalsolution.mentessolidarias.entities.endereco.Endereco;
import com.globalsolution.mentessolidarias.entities.usuario.UsuarioEntity;
import com.globalsolution.mentessolidarias.entities.usuario.agenda.AgendaEntity;
import com.globalsolution.mentessolidarias.repositories.usuario.AgendaRepository;
import com.globalsolution.mentessolidarias.repositories.usuario.ProfissionalRepository;
import com.globalsolution.mentessolidarias.repositories.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ValidacaoAgenda {
    @Autowired
    private AgendaRepository agendaRepository;
    @Autowired
    private ProfissionalRepository profissionalRepository;

    public List<DadosDetalhamentoAgenda> cadastrar(List<DadosCadastroAgenda> dados){

        var profissional = profissionalRepository.getReferenceById(dados.get(1).cpf());
            List<AgendaEntity> agendas = new ArrayList<>();
        for (DadosCadastroAgenda dado : dados){
             agendas.add(AgendaEntity.builder()
                             .diaSemana(dado.diaSemana())
                             .horario(dado.horario())
                             .profissional(profissional)
                     .build());
        }
        List<DadosDetalhamentoAgenda> dto = new ArrayList<>();
        for(AgendaEntity agenda : agendas){
            agendaRepository.save(agenda);
            dto.add(new DadosDetalhamentoAgenda(agenda));
        }

        return dto;
    }
}
