package com.globalsolution.mentessolidarias.entities.usuario.profissional;

import com.globalsolution.mentessolidarias.entities.usuario.UsuarioEntity;
import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "special_profissional")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProfissionalEntity extends UsuarioEntity {

    @Column(name = "certificacao")
    private Long certificacao;
    @Column(name = "formacao")
    private String formacao;
    @Column(name = "cnpj")
    private Long cnpj;
}
