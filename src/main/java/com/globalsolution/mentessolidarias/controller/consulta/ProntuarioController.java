package com.globalsolution.mentessolidarias.controller.consulta;

import com.globalsolution.mentessolidarias.controller.consulta.dto.DadosCadastroProntuario;
import com.globalsolution.mentessolidarias.controller.consulta.validacao.ValidacaoProntuario;
import com.globalsolution.mentessolidarias.repositories.consulta.ProntuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/prontuario")
public class ProntuarioController {
    @Autowired
    private ValidacaoProntuario validacaoProntuario;
    @Autowired
    private ProntuarioRepository prontuarioRepository;
    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroProntuario dados){
        var dto = validacaoProntuario.cadastrar(dados);
        return ResponseEntity.ok(dto);
    }
}
