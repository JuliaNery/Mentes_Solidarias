package com.globalsolution.mentessolidarias.repositories.usuario;

import com.globalsolution.mentessolidarias.entities.usuario.TipoUsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoUsuarioRepository extends JpaRepository<TipoUsuarioEntity, Long> {
}
