package com.globalsolution.mentessolidarias.repositories.consulta;

import com.globalsolution.mentessolidarias.entities.consulta.AvaliacaoEntity;
import com.globalsolution.mentessolidarias.entities.usuario.TipoUsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Arrays;
import java.util.List;

public interface AvaliacaoRepository extends JpaRepository<AvaliacaoEntity, Long> {
    @Query(value = """
            select * from tb_avaliacao a
            inner join tb_consulta c on a.id_consulta = c.id_consulta
            where c.cpf_paciente = :cpf
            """, nativeQuery = true)
    List<AvaliacaoEntity> findByPacienteCpf(@Param("cpf") Long cpf);

    @Query(value = """
            select * from tb_avaliacao a
            inner join tb_consulta c on a.id_consulta = c.id_consulta
            where c.cpf_profissional = :cpf
            """, nativeQuery = true)
    List<AvaliacaoEntity> findByProfissionalCpf(@Param("cpf") Long cpf);

    @Query(value = """
            select round(avg(a.nota)) media from tb_avaliacao a
            inner join tb_consulta c on a.id_consulta = c.id_consulta
            where c.cpf_profissional = :cpf
            group by c.cpf_profissional
            """, nativeQuery = true)
    Double getMediaByProfissionalCpf(@Param("cpf") Long cpf);
}
