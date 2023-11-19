package com.globalsolution.mentessolidarias.entities.consulta;

import com.globalsolution.mentessolidarias.entities.usuario.paciente.PacienteEntity;
import com.globalsolution.mentessolidarias.entities.usuario.profissional.ProfissionalEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tb_consulta")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ConsultaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_consulta")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cpf_paciente")
    private PacienteEntity paciente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cpf_profissional")
    private ProfissionalEntity profissional;

    @Column(name = "data_hora")
    private LocalDateTime data;

    @Column(name = "link_consulta")
    private String link;
}
