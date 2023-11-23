package com.globalsolution.mentessolidarias.entities.documentos.receita;

import com.globalsolution.mentessolidarias.controller.documentos.dto.DadosCadastroReceitaMedicamento;
import jakarta.persistence.*;
import lombok.*;

@Data
@Entity(name = "assoc_receita_medicamento")
@Table(name = "assoc_receita_medicamento")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ReceitaMedicamentoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_receita_medicamento")
    private Long id;

    @Column(name = "descricao")
    private String descricao;
    @Column(name = "freq_duracao")
    private String frequenciaAdmin;
    @Column(name = "duracao_admin")
    private String duracaoAdmin;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_receita")
    private ReceitaEntity receita;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_medicamento")
    private MedicamentoEntity medicamento;


}
