package com.globalsolution.mentessolidarias.repositories.documentos.receita;

import com.globalsolution.mentessolidarias.entities.documentos.receita.ReceitaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceitaRepository extends JpaRepository<ReceitaEntity, Long> {
}
