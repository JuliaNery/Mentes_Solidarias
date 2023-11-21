package com.globalsolution.mentessolidarias.repositories.usuario;

import com.globalsolution.mentessolidarias.entities.usuario.TipoUsuarioEntity;
import com.globalsolution.mentessolidarias.entities.usuario.profissional.ProfissionalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfissionalRepository extends JpaRepository<ProfissionalEntity, Long> {
}
