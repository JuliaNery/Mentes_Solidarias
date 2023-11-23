package com.globalsolution.mentessolidarias.controller.documentos.receita;

import com.globalsolution.mentessolidarias.controller.documentos.dto.DadosCadastroReceitaMedicamento;
import com.globalsolution.mentessolidarias.controller.documentos.dto.DadosDetalhamentoReceitaMedicamento;
import com.globalsolution.mentessolidarias.controller.documentos.validacao.ValidacaoReceitaMedicamento;
 import com.globalsolution.mentessolidarias.repositories.documentos.receita.ReceitaMedicamentoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/receitareceitaMedicamento")
public class ReceitaMedicamentoController {
    @Autowired
    private ReceitaMedicamentoRepository receitaMedicamentoRepository;
    @Autowired
    private ValidacaoReceitaMedicamento validacaoReceitaMedicamento;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroReceitaMedicamento dados){
        var dto = validacaoReceitaMedicamento.cadastrar(dados);
        return ResponseEntity.ok(dto);
    }
    @GetMapping
    public ResponseEntity<List<DadosDetalhamentoReceitaMedicamento>> listar(){
        var receitaMedicamento = receitaMedicamentoRepository.findAll().stream().map(DadosDetalhamentoReceitaMedicamento :: new).collect(Collectors.toList());
        return ResponseEntity.ok(receitaMedicamento);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<DadosDetalhamentoReceitaMedicamento>> listarReceita(@PathVariable Long id) {
        var receitaMedicamento = receitaMedicamentoRepository.findByReceitaId(id).stream().map(DadosDetalhamentoReceitaMedicamento :: new).collect(Collectors.toList());
        return ResponseEntity.ok(receitaMedicamento);
    }
}
