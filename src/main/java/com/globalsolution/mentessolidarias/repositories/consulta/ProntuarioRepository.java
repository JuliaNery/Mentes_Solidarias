package com.globalsolution.mentessolidarias.repositories.consulta;

import com.globalsolution.mentessolidarias.entities.consulta.ProntuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProntuarioRepository  extends JpaRepository<ProntuarioEntity, Long> {
}
