package com.globalsolution.mentessolidarias.repositories.consulta;

import com.globalsolution.mentessolidarias.entities.consulta.ConsultaEntity;
import com.globalsolution.mentessolidarias.entities.documentos.receita.ReceitaMedicamentoEntity;
import com.globalsolution.mentessolidarias.entities.usuario.TipoUsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsultaRepository extends JpaRepository<ConsultaEntity, Long> {
    List<ConsultaEntity> findByPacienteCpf(Long cpf);

    List<ConsultaEntity> findByProfissionalCpf(Long cpf);

}
