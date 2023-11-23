package com.globalsolution.mentessolidarias.entities.usuario.agenda;

import com.globalsolution.mentessolidarias.entities.enuns.DiaSemana;
import com.globalsolution.mentessolidarias.entities.enuns.TipoUsuario;
import com.globalsolution.mentessolidarias.entities.usuario.TipoUsuarioEntity;
import com.globalsolution.mentessolidarias.entities.usuario.UsuarioEntity;
import com.globalsolution.mentessolidarias.entities.usuario.profissional.ProfissionalEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;

@Data
@Entity
@Table(name = "tb_agenda")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class AgendaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_agenda")
    private Long id;
    @Column(name = "dia_semana")
    @Enumerated
    private DiaSemana diaSemana;

    @Column(name = "horario")
    private LocalTime horario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cpf_profissional")
    private ProfissionalEntity profissional;
}
