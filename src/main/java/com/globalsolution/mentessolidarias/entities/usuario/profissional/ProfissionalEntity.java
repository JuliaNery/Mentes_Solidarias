package com.globalsolution.mentessolidarias.entities.usuario.profissional;

import com.globalsolution.mentessolidarias.entities.usuario.UsuarioEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@Entity
@Table(name = "special_profissional")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "cpf")
public class ProfissionalEntity {

    @Id
    @Column(name = "cpf")
    private Long cpf;
    @Column(name = "certificacao")
    private Long certificacao;
    @Column(name = "formacao")
    private String formacao;
    @Column(name = "cnpj")
    private Long cnpj;

    @OneToOne
    @JoinColumn(name = "cpf", referencedColumnName = "cpf")
    private UsuarioEntity usuario;
}
