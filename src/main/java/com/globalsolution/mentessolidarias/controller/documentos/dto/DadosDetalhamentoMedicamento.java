package com.globalsolution.mentessolidarias.controller.documentos.dto;

import com.globalsolution.mentessolidarias.entities.documentos.receita.MedicamentoEntity;

public record DadosDetalhamentoMedicamento(Long id, String nome, String fabricante, String viaAdministracao, String principioAtivo) {

    public DadosDetalhamentoMedicamento(MedicamentoEntity medicamento) {
        this(medicamento.getId(), medicamento.getNome(), medicamento.getFabricante(), medicamento.getViaAdministracao(), medicamento.getPrincipioAtivo());
    }
}
