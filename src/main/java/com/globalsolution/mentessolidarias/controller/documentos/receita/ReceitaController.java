package com.globalsolution.mentessolidarias.controller.documentos.receita;

import com.globalsolution.mentessolidarias.controller.documentos.dto.DadosCadastroReceita;
import com.globalsolution.mentessolidarias.controller.documentos.dto.DadosDetalhamentoReceita;

import com.globalsolution.mentessolidarias.entities.documentos.receita.ReceitaEntity;
import com.globalsolution.mentessolidarias.repositories.documentos.receita.ReceitaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/receita")
public class ReceitaController {
    @Autowired
    private ReceitaRepository receitaRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroReceita dados, UriComponentsBuilder uriBuilder){
        var receita = new ReceitaEntity(dados);
        receitaRepository.save(receita);
        var uri = uriBuilder.path("/receita/{id}").buildAndExpand(receita.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoReceita(receita));
    }
    @GetMapping
    public ResponseEntity<List<DadosDetalhamentoReceita>> listar(){
        var receita = receitaRepository.findAll().stream().map(DadosDetalhamentoReceita :: new).collect(Collectors.toList());
        return ResponseEntity.ok(receita);
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var receita = receitaRepository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoReceita(receita));
    }
}
