package com.globalsolution.mentessolidarias.repositories.documentos.receita;

import com.globalsolution.mentessolidarias.controller.documentos.dto.DadosDetalhamentoReceitaMedicamento;
import com.globalsolution.mentessolidarias.entities.documentos.receita.ReceitaEntity;
import com.globalsolution.mentessolidarias.entities.documentos.receita.ReceitaMedicamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReceitaMedicamentoRepository extends JpaRepository<ReceitaMedicamentoEntity, Long> {
    List<ReceitaMedicamentoEntity> findByReceitaId(Long id);

}
