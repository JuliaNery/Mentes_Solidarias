package com.globalsolution.mentessolidarias.entities.usuario;

import com.globalsolution.mentessolidarias.entities.enuns.TipoUsuario;
import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "tb_tipo_usuario")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TipoUsuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_usuario")
    private Long id;
    @Column(name = "tipo_usuario")
    @Enumerated
    private TipoUsuario tipoUsuario;
}
