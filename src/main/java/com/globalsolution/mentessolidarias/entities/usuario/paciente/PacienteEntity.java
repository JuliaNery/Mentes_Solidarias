package com.globalsolution.mentessolidarias.entities.usuario.paciente;

import com.globalsolution.mentessolidarias.entities.enuns.EstadoCivil;
import com.globalsolution.mentessolidarias.entities.usuario.UsuarioEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@Entity
@Table(name = "special_paciente")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "cpf")
public class PacienteEntity {

    @Id
    @Column(name = "cpf")
    private Long cpf;

    @Column(name = "filhos")
    private Integer filhos;
    @Column(name = "ocupacao")
    private String ocupacao;
    @Enumerated(EnumType.STRING)
    @Column(name = "estado_civil")
    private EstadoCivil estadoCivil;
    @Column(name = "niss")
    private Long niss;

    @OneToOne
    @JoinColumn(name = "cpf", referencedColumnName = "cpf")
    private UsuarioEntity usuario;
}
