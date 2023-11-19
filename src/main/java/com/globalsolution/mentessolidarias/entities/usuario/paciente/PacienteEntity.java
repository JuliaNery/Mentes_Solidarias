package com.globalsolution.mentessolidarias.entities.usuario.paciente;

import com.globalsolution.mentessolidarias.entities.enuns.EstadoCivil;
import com.globalsolution.mentessolidarias.entities.usuario.UsuarioEntity;
import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "special_paciente")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PacienteEntity extends UsuarioEntity {

    @Column(name = "filhos")
    private Integer filhos;
    @Column(name = "ocupacao")
    private String ocupacao;
    @Enumerated(EnumType.STRING)
    @Column(name = "estado_civil")
    private EstadoCivil estadoCivil;
    @Column(name = "niss")
    private Long niss;
}
