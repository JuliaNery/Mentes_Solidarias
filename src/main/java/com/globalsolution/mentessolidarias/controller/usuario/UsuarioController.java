package com.globalsolution.mentessolidarias.controller.usuario;

import com.globalsolution.mentessolidarias.controller.usuario.dto.DadosCadastroUsuario;
import com.globalsolution.mentessolidarias.controller.usuario.dto.DadosDetalhamentoUsuario;
import com.globalsolution.mentessolidarias.controller.usuario.dto.DadosLogin;
import com.globalsolution.mentessolidarias.controller.usuario.validacao.ValidacaoUsuario;
import com.globalsolution.mentessolidarias.repositories.usuario.UsuarioRepository;
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
@RequestMapping(value = "/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private ValidacaoUsuario validacaoUsuario;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroUsuario dados){
        var dto = validacaoUsuario.cadastrar(dados);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<List<DadosDetalhamentoUsuario>> listar(){
        var usuario = usuarioRepository.findAll().stream().map(DadosDetalhamentoUsuario :: new).collect(Collectors.toList());
        return ResponseEntity.ok(usuario);
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var usuario = usuarioRepository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoUsuario(usuario));
    }


}
