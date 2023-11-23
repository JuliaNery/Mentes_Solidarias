package com.globalsolution.mentessolidarias.controller.usuario.agenda;

import com.globalsolution.mentessolidarias.controller.usuario.dto.DadosCadastroHorario;
import com.globalsolution.mentessolidarias.controller.usuario.dto.DadosDetalhamentoHorario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/horario")
public class HorarioController {
    @Autowired
    private ValidacaoHorario validacaoHorario;

    @PostMapping
    @Transactional
    public ResponseEntity<List<DadosDetalhamentoHorario>> cadastrar(@RequestBody @Valid List<DadosCadastroHorario> dados){
        var dto = validacaoHorario.cadastrar(dados);
        return ResponseEntity.ok(dto);
    }
}
