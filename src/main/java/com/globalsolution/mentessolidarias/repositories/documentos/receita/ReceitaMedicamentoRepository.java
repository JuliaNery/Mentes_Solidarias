package com.globalsolution.mentessolidarias.repositories.documentos.receita;

import com.globalsolution.mentessolidarias.entities.documentos.receita.ReceitaMedicamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceitaMedicamentoRepository extends JpaRepository<ReceitaMedicamentoEntity, Long> {
}
