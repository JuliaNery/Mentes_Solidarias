package com.globalsolution.mentessolidarias.controller.consulta;

import com.globalsolution.mentessolidarias.controller.consulta.dto.DadosCadastroConsulta;
import com.globalsolution.mentessolidarias.controller.consulta.dto.DadosDetalhamentoConsulta;
import com.globalsolution.mentessolidarias.controller.consulta.validacao.ValidacaoConsulta;
import com.globalsolution.mentessolidarias.repositories.consulta.ConsultaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/consulta")
public class ConsultaController {
    @Autowired
    private ValidacaoConsulta validacaoConsulta;
    @Autowired
    private ConsultaRepository consultaRepository;
    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroConsulta dados){
        var dto = validacaoConsulta.cadastrar(dados);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var consulta = consultaRepository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoConsulta(consulta));
    }
    @GetMapping("/paciente/{cpf}")
    public ResponseEntity<List<DadosDetalhamentoConsulta>> listarConsultaPaciente(@PathVariable Long cpf) {
        var consulta = consultaRepository.findByPacienteCpf(cpf).stream().map(DadosDetalhamentoConsulta:: new).collect(Collectors.toList());
        return ResponseEntity.ok(consulta);
    }

    @GetMapping("/profissional/{cpf}")
    public ResponseEntity<List<DadosDetalhamentoConsulta>> listarConsultaProfissional(@PathVariable Long cpf) {
        var consulta = consultaRepository.findByProfissionalCpf(cpf).stream().map(DadosDetalhamentoConsulta:: new).collect(Collectors.toList());
        return ResponseEntity.ok(consulta);
    }
}
