package com.globalsolution.mentessolidarias.entities.usuario.agenda;

import com.globalsolution.mentessolidarias.entities.enuns.DiaSemana;
import com.globalsolution.mentessolidarias.entities.usuario.UsuarioEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;

@Data
@Entity
@Table(name = "tb_horario")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class HorarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_horario")
    private Long id;
    @Column(name = "horario")
    @Enumerated
    private LocalTime horario;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_agenda")
    private AgendaEntity agenda;
}
