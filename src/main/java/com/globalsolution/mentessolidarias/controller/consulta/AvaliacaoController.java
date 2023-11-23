package com.globalsolution.mentessolidarias.controller.consulta;

import com.globalsolution.mentessolidarias.controller.consulta.dto.DadosCadastroAvaliacao;
import com.globalsolution.mentessolidarias.controller.consulta.dto.DadosDetalhamentoAvaliacao;
import com.globalsolution.mentessolidarias.controller.consulta.validacao.ValidacaoAvaliacao;
import com.globalsolution.mentessolidarias.repositories.consulta.AvaliacaoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/avaliacao")
public class AvaliacaoController {
    @Autowired
    private ValidacaoAvaliacao validacaoAvaliacao;

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroAvaliacao dados){
        var dto = validacaoAvaliacao.cadastrar(dados);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/paciente/{cpf}")
    public ResponseEntity<List<DadosDetalhamentoAvaliacao>> listarAvaliacaoPaciente(@PathVariable Long cpf) {
        var avaliacao = avaliacaoRepository.findByPacienteCpf(cpf).stream().map(DadosDetalhamentoAvaliacao:: new).collect(Collectors.toList());
        return ResponseEntity.ok(avaliacao);
    }

    @GetMapping("/profissional/{cpf}")
    public ResponseEntity<List<DadosDetalhamentoAvaliacao>> listarAvaliacaoProfissional(@PathVariable Long cpf) {
        var avaliacao = avaliacaoRepository.findByProfissionalCpf(cpf).stream().map(DadosDetalhamentoAvaliacao:: new).collect(Collectors.toList());
        return ResponseEntity.ok(avaliacao);
    }

    @GetMapping("/media/{cpf}")
    public ResponseEntity consultarMediaProfissional(@PathVariable Long cpf) {
        var media = avaliacaoRepository.getMediaByProfissionalCpf(cpf);
        return ResponseEntity.ok(media);
    }


}
