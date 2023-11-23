package com.globalsolution.mentessolidarias.repositories.usuario;

import com.globalsolution.mentessolidarias.entities.enuns.TipoUsuario;
import com.globalsolution.mentessolidarias.entities.usuario.TipoUsuarioEntity;
import com.globalsolution.mentessolidarias.entities.usuario.profissional.ProfissionalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface ProfissionalRepository extends JpaRepository<ProfissionalEntity, Long> {
    @Query(value = """
                select p from special_profissional p
                inner join main_usuario u on p.cpf = u.cpf
                inner join tb_tipo_usuario tu ON u.id_tipo_usuario = tu.id_tipo_usuario
                where tu.tipo_usuario = :especialidade
                and u.genero = :genero
                AND p.cpf not in(
                        select c from tb_consulta 
                        where c.data_hora = :data
                        and
                )
            """, nativeQuery = true)
    ProfissionalEntity getProfissionalLivre(LocalDateTime data, TipoUsuario especialidade, String genero);
}
