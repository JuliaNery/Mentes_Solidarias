package com.globalsolution.mentessolidarias.repositories.consulta;

import com.globalsolution.mentessolidarias.entities.consulta.ConsultaEntity;
import com.globalsolution.mentessolidarias.entities.usuario.TipoUsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultaRepository extends JpaRepository<ConsultaEntity, Long> {
}
