package com.globalsolution.mentessolidarias.repositories.usuario;

import com.globalsolution.mentessolidarias.entities.usuario.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
    @Query(value = """
            Select * from main_usuario
            where cpf = :cpf and senha = :senha
            """,nativeQuery = true)
    UsuarioEntity getReferenceByCpfAndSenha(@Param("cpf") Long cpf,@Param("senha") String senha);
}
