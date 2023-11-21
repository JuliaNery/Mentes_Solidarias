package com.globalsolution.mentessolidarias.repositories.documentos.receita;

import com.globalsolution.mentessolidarias.entities.documentos.receita.MedicamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicamentoRepository extends JpaRepository<MedicamentoEntity, Long> {
}
