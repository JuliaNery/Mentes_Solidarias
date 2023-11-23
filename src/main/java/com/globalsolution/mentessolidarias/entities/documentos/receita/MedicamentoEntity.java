package com.globalsolution.mentessolidarias.entities.documentos.receita;

import com.globalsolution.mentessolidarias.controller.documentos.dto.DadosCadastroMedicamento;
import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "tb_mecadimento")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MedicamentoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_medicamento")
    private Long id;

    @Column(name ="nome")
    private String nome;

    @Column(name = "fabricante")
    private String fabricante;

    @Column(name = "via_admin")
    private String viaAdministracao;

    @Column(name = "principio_ativo")
    private String principioAtivo;

    public MedicamentoEntity(DadosCadastroMedicamento dados) {
        this.setNome(dados.nome());
        this.setFabricante(dados.fabricante());
        this.setViaAdministracao(dados.viaAdministracao());
        this.setPrincipioAtivo(dados.principioAtivo());
    }
}
