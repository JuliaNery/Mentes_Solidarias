package com.globalsolution.mentessolidarias.controller.consulta.validacao;

import com.globalsolution.mentessolidarias.controller.consulta.dto.DadosCadastroProntuario;
import com.globalsolution.mentessolidarias.controller.consulta.dto.DadosDetalhamentoProntuario;
import com.globalsolution.mentessolidarias.entities.consulta.ProntuarioEntity;
import com.globalsolution.mentessolidarias.repositories.consulta.ProntuarioRepository;
import com.globalsolution.mentessolidarias.repositories.consulta.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidacaoProntuario {

    @Autowired
    private ProntuarioRepository prontuarioRepository;
    @Autowired
    private ConsultaRepository consultaRepository;

    public DadosDetalhamentoProntuario cadastrar(DadosCadastroProntuario dados){
        var consulta = consultaRepository.getReferenceById(dados.idConsulta());

        var prontuario = ProntuarioEntity.builder()
                .data(dados.data())
                .descricao(dados.descricao())
                .consulta(consulta)
                .build();
        prontuarioRepository.save(prontuario);
        return new DadosDetalhamentoProntuario(prontuario);
    }
}
