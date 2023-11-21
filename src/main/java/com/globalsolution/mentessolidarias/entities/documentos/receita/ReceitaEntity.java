package com.globalsolution.mentessolidarias.entities.documentos.receita;

import com.globalsolution.mentessolidarias.entities.consulta.ConsultaEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tb_receita")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ReceitaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_receita")
    private Long id;

    @Column(name = "data_hora")
    private LocalDateTime data;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_consulta")
    private ConsultaEntity consulta;
}
