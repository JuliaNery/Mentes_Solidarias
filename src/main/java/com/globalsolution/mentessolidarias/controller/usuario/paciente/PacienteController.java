package com.globalsolution.mentessolidarias.controller.usuario.paciente;

import com.globalsolution.mentessolidarias.controller.usuario.dto.DadosCadastroPaciente;
import com.globalsolution.mentessolidarias.controller.usuario.dto.DadosDetalhamentoUsuario;
import com.globalsolution.mentessolidarias.controller.usuario.dto.DadosDetalhamentoPaciente;
import com.globalsolution.mentessolidarias.controller.usuario.validacao.ValidacaoPaciente;
import com.globalsolution.mentessolidarias.repositories.usuario.PacienteRepository;
import com.globalsolution.mentessolidarias.repositories.usuario.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/paciente")
public class PacienteController {

    @Autowired
    private ValidacaoPaciente validacaoPaciente;

    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroPaciente dados){
        var dto = validacaoPaciente.cadastrar(dados);
        return ResponseEntity.ok(dto);
    }

//    @GetMapping
//    public ResponseEntity<List<DadosDetalhamentoPaciente>> listar(){
//        var paciente = pacienteRepository.findAll().stream().map(DadosDetalhamentoPaciente :: new).collect(Collectors.toList());
//        return ResponseEntity.ok(paciente);
//    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var usuario = usuarioRepository.getReferenceById(id);
        var paciente = pacienteRepository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoPaciente(new DadosDetalhamentoUsuario(usuario), paciente));
    }


}
