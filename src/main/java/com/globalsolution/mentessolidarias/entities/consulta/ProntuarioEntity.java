package com.globalsolution.mentessolidarias.entities.consulta;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tb_prontuario")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ProntuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_prontuario")
    private Long id;

    @Column(name = "data_hora")
    private LocalDateTime data;

    @Column(name = "descricao")
    private String descricao;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_consulta")
    private ConsultaEntity consulta;
}
