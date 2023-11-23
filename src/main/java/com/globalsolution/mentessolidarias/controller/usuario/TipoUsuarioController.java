package com.globalsolution.mentessolidarias.controller.usuario;

import com.globalsolution.mentessolidarias.controller.usuario.dto.DadosCadastroTipoUsuario;
import com.globalsolution.mentessolidarias.controller.usuario.dto.DadosDetalhamentoTipoUsuario;
import com.globalsolution.mentessolidarias.entities.usuario.TipoUsuarioEntity;
import com.globalsolution.mentessolidarias.repositories.usuario.TipoUsuarioRepository;
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
@RequestMapping(value = "/tipousuario")
public class TipoUsuarioController {
    @Autowired
    private TipoUsuarioRepository tipoUsuarioRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroTipoUsuario dados, UriComponentsBuilder uriBuilder){
        var tipoUsuario = new TipoUsuarioEntity(dados);
        tipoUsuarioRepository.save(tipoUsuario);
        var uri = uriBuilder.path("/tipoUsuario/{id}").buildAndExpand(tipoUsuario.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoTipoUsuario(tipoUsuario));
    }
    @GetMapping
    public ResponseEntity<List<DadosDetalhamentoTipoUsuario>> listar(){
        var tipoUsuario = tipoUsuarioRepository.findAll().stream().map(DadosDetalhamentoTipoUsuario :: new).collect(Collectors.toList());
        return ResponseEntity.ok(tipoUsuario);
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var tipoUsuario = tipoUsuarioRepository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoTipoUsuario(tipoUsuario));
    }
}
