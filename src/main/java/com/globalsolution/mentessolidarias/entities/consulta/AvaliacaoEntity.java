package com.globalsolution.mentessolidarias.entities.consulta;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "tb_avaliacao")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class AvaliacaoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_avaliacao")
    private Long id;

    @Column(name = "nota")
    private Short nota;

    @Column(name = "avaliacao")
    private String avaliacao;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_consulta")
    private ConsultaEntity consulta;

}
