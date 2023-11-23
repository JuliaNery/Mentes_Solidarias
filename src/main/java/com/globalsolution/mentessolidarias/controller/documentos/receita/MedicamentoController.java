package com.globalsolution.mentessolidarias.controller.documentos.receita;

import com.globalsolution.mentessolidarias.controller.documentos.dto.DadosCadastroMedicamento;
import com.globalsolution.mentessolidarias.controller.documentos.dto.DadosDetalhamentoMedicamento;
import com.globalsolution.mentessolidarias.entities.documentos.receita.MedicamentoEntity;
import com.globalsolution.mentessolidarias.repositories.documentos.receita.MedicamentoRepository;
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
@RequestMapping(value = "/medicamento")
public class MedicamentoController {
    @Autowired
    private MedicamentoRepository medicamentoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroMedicamento dados, UriComponentsBuilder uriBuilder){
        var medicamento = new MedicamentoEntity(dados);
        medicamentoRepository.save(medicamento);
        var uri = uriBuilder.path("/medicamento/{id}").buildAndExpand(medicamento.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoMedicamento(medicamento));
    }
    @GetMapping
    public ResponseEntity<List<DadosDetalhamentoMedicamento>> listar(){
        var medicamento = medicamentoRepository.findAll().stream().map(DadosDetalhamentoMedicamento :: new).collect(Collectors.toList());
        return ResponseEntity.ok(medicamento);
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var medicamento = medicamentoRepository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoMedicamento(medicamento));
    }
}
