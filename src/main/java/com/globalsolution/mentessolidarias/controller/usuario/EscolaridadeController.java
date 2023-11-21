package com.globalsolution.mentessolidarias.controller.usuario;

import com.globalsolution.mentessolidarias.controller.usuario.dto.DadosCadastroEscolaridade;
import com.globalsolution.mentessolidarias.controller.usuario.dto.DadosDetalhamentoEscolaridade;
import com.globalsolution.mentessolidarias.entities.usuario.EscolaridadeEntity;
import com.globalsolution.mentessolidarias.repositories.usuario.EscolaridadeRepository;
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
@RequestMapping(value = "/escolaridade")
public class EscolaridadeController {
    @Autowired
    private EscolaridadeRepository escolaridadeRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroEscolaridade dados, UriComponentsBuilder uriBuilder){
        var escolaridade = new EscolaridadeEntity(dados);
        escolaridadeRepository.save(escolaridade);
        var uri = uriBuilder.path("/escolaridade/{id}").buildAndExpand(escolaridade.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoEscolaridade(escolaridade));
    }
    @GetMapping
    public ResponseEntity<List<DadosDetalhamentoEscolaridade>> listar(){
        var escolaridade = escolaridadeRepository.findAll().stream().map(DadosDetalhamentoEscolaridade :: new).collect(Collectors.toList());
        return ResponseEntity.ok(escolaridade);
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var escolaridade = escolaridadeRepository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoEscolaridade(escolaridade));
    }
}
