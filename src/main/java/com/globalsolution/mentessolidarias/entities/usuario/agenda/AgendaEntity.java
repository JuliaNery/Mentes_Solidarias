package com.globalsolution.mentessolidarias.entities.usuario.agenda;

import com.globalsolution.mentessolidarias.entities.enuns.DiaSemana;
import com.globalsolution.mentessolidarias.entities.enuns.TipoUsuario;
import com.globalsolution.mentessolidarias.entities.usuario.TipoUsuarioEntity;
import com.globalsolution.mentessolidarias.entities.usuario.UsuarioEntity;
import jakarta.persistence.*;
import lombok.*;

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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    private UsuarioEntity usuario;
}
