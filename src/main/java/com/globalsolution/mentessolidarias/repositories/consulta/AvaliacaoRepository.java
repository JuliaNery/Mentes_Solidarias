package com.globalsolution.mentessolidarias.repositories.consulta;

import com.globalsolution.mentessolidarias.entities.consulta.AvaliacaoEntity;
import com.globalsolution.mentessolidarias.entities.usuario.TipoUsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvaliacaoRepository extends JpaRepository<AvaliacaoEntity, Long> {
}
