package com.globalsolution.mentessolidarias.controller.usuario.agenda;

import com.globalsolution.mentessolidarias.controller.consulta.validacao.ValidacaoAgenda;
import com.globalsolution.mentessolidarias.controller.usuario.dto.DadosCadastroAgenda;
import com.globalsolution.mentessolidarias.controller.usuario.dto.DadosCadastroTipoUsuario;
import com.globalsolution.mentessolidarias.controller.usuario.dto.DadosDetalhamentoAgenda;
import com.globalsolution.mentessolidarias.controller.usuario.dto.DadosDetalhamentoTipoUsuario;
import com.globalsolution.mentessolidarias.entities.usuario.TipoUsuarioEntity;
import com.globalsolution.mentessolidarias.entities.usuario.agenda.AgendaEntity;
import com.globalsolution.mentessolidarias.repositories.usuario.AgendaRepository;
import com.globalsolution.mentessolidarias.repositories.usuario.TipoUsuarioRepository;
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
@RequestMapping(value = "/agenda")
public class AgendaController {

    @Autowired
    private ValidacaoAgenda validacaoAgenda;

    @PostMapping
    @Transactional
    public ResponseEntity<List<DadosDetalhamentoAgenda>> cadastrar(@RequestBody @Valid List<DadosCadastroAgenda> dados){
        var dto = validacaoAgenda.cadastrar(dados);
        return ResponseEntity.ok(dto);
    }


}
