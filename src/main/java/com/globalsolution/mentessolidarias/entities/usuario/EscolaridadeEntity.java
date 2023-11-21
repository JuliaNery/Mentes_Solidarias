package com.globalsolution.mentessolidarias.entities.usuario;

import com.globalsolution.mentessolidarias.controller.usuario.dto.DadosCadastroEscolaridade;
import com.globalsolution.mentessolidarias.entities.enuns.Escolaridade;
import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "tb_escolaridade")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EscolaridadeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_escolaridade")
    private Long id;
    @Column(name = "escolaridade")
    @Enumerated(EnumType.STRING)
    private Escolaridade escolaridade;

    public EscolaridadeEntity(DadosCadastroEscolaridade dados) {
        this.setEscolaridade(dados.escolaridade());
    }
}
