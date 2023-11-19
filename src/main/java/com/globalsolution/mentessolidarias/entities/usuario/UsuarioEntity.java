package com.globalsolution.mentessolidarias.entities.usuario;

import com.globalsolution.mentessolidarias.entities.endereco.Endereco;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "main_usuario")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UsuarioEntity {
    @Id
    @Column(name = "cpf")
    private Long cpf;
    @Column(name = "nome")
    private String nome;
    @Column(name = "genero")
    @Enumerated(EnumType.STRING)
    private String genero;
    @Column(name = "num_telefone")
    private Long telefone;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_escolaridade")
    private EscolaridadeEntity escolaridadeEntity;
    @Column(name = "dt_nasc")
    private LocalDate dtNasc;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_usuario")
    private TipoUsuarioEntity tipoUsuarioEntity;
    @Column(name = "email")
    private String email;
    @Column(name = "senha")
    private String senha;
    @Embedded
    private Endereco endereco;
}
