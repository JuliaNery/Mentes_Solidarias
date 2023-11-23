package com.globalsolution.mentessolidarias.controller.consulta.validacao;

import com.globalsolution.mentessolidarias.controller.consulta.dto.DadosCadastroAvaliacao;
import com.globalsolution.mentessolidarias.controller.consulta.dto.DadosDetalhamentoAvaliacao;
import com.globalsolution.mentessolidarias.entities.consulta.AvaliacaoEntity;
import com.globalsolution.mentessolidarias.repositories.consulta.AvaliacaoRepository;
import com.globalsolution.mentessolidarias.repositories.consulta.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidacaoAvaliacao {
    @Autowired
    private AvaliacaoRepository avaliacaoRepository;
    @Autowired
    private ConsultaRepository consultaRepository;

    public DadosDetalhamentoAvaliacao cadastrar(DadosCadastroAvaliacao dados){
        var consulta = consultaRepository.getReferenceById(dados.idConsulta());

        var avaliacao = AvaliacaoEntity.builder()
                .nota(dados.nota())
                .avaliacao(dados.avaliacao())
                .consulta(consulta)
                .build();
        avaliacaoRepository.save(avaliacao);
        return new DadosDetalhamentoAvaliacao(avaliacao);
    }
}
