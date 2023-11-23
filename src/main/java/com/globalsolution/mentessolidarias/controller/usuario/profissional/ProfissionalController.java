package com.globalsolution.mentessolidarias.controller.usuario.profissional;

import com.globalsolution.mentessolidarias.controller.usuario.dto.DadosCadastroProfissional;
import com.globalsolution.mentessolidarias.controller.usuario.dto.DadosDetalhamentoPaciente;
import com.globalsolution.mentessolidarias.controller.usuario.dto.DadosDetalhamentoProfissional;
import com.globalsolution.mentessolidarias.controller.usuario.dto.DadosDetalhamentoUsuario;
import com.globalsolution.mentessolidarias.controller.usuario.validacao.ValidacaoProfissional;
import com.globalsolution.mentessolidarias.repositories.usuario.ProfissionalRepository;
import com.globalsolution.mentessolidarias.repositories.usuario.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/profissional")
public class ProfissionalController {
    @Autowired
    private ValidacaoProfissional validacaoProfissional;

    @Autowired
    private ProfissionalRepository profissionalRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroProfissional dados){
        var dto = validacaoProfissional.cadastrar(dados);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var usuario = usuarioRepository.getReferenceById(id);
        var profissional = profissionalRepository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoProfissional(new DadosDetalhamentoUsuario(usuario), profissional));
    }
}
