package com.globalsolution.mentessolidarias.controller.documentos.validacao;

import com.globalsolution.mentessolidarias.controller.documentos.dto.DadosCadastroReceitaMedicamento;
import com.globalsolution.mentessolidarias.controller.documentos.dto.DadosDetalhamentoReceitaMedicamento;
import com.globalsolution.mentessolidarias.entities.documentos.receita.ReceitaMedicamentoEntity;
import com.globalsolution.mentessolidarias.repositories.documentos.receita.MedicamentoRepository;
import com.globalsolution.mentessolidarias.repositories.documentos.receita.ReceitaMedicamentoRepository;
import com.globalsolution.mentessolidarias.repositories.documentos.receita.ReceitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ValidacaoReceitaMedicamento {
    @Autowired
    private ReceitaMedicamentoRepository receitaMedicamentoRepository;

    @Autowired
    private ReceitaRepository receitaRepository;

    @Autowired
    private MedicamentoRepository medicamentoRepository;

    public DadosDetalhamentoReceitaMedicamento cadastrar(DadosCadastroReceitaMedicamento dados){

        var receita = receitaRepository.getReferenceById(dados.idReceita());
        var medicamento = medicamentoRepository.getReferenceById(dados.idMedicamento());


        var receitaMedicamento = new ReceitaMedicamentoEntity(dados.idMedicamento(),
                dados.descricao(), dados.frequenciaAdmin(), dados.duracaoAdmin(), receita, medicamento

        );
        receitaMedicamentoRepository.save(receitaMedicamento);
        return new DadosDetalhamentoReceitaMedicamento(receitaMedicamento);
    }

}
