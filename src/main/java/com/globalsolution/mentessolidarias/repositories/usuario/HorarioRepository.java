package com.globalsolution.mentessolidarias.repositories.usuario;

import com.globalsolution.mentessolidarias.entities.usuario.agenda.AgendaEntity;
import com.globalsolution.mentessolidarias.entities.usuario.agenda.HorarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HorarioRepository extends JpaRepository<HorarioEntity, Long> {
}
