package com.globalsolution.mentessolidarias.controller.usuario.validacao;

import com.globalsolution.mentessolidarias.controller.usuario.dto.DadosCadastroProfissional;
import com.globalsolution.mentessolidarias.controller.usuario.dto.DadosDetalhamentoProfissional;
import com.globalsolution.mentessolidarias.entities.usuario.profissional.ProfissionalEntity;
import com.globalsolution.mentessolidarias.repositories.usuario.ProfissionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidacaoProfissional {
    @Autowired
    ValidacaoUsuario validacaoUsuario;
    @Autowired
    ProfissionalRepository profissionalRepository;

    public DadosDetalhamentoProfissional cadastrar(DadosCadastroProfissional dados){
        var dto = dados.dadosCadastroUsuario();
        var usuario = validacaoUsuario.cadastrar(dto);

        var profissional = ProfissionalEntity.builder()
                .cpf(usuario.cpf())
                .certificacao(dados.certificacao())
                .formacao(dados.formacao())
                .cnpj(dados.cnpj())
                .build();
        profissionalRepository.save(profissional);
        return new DadosDetalhamentoProfissional(usuario, profissional);
    }
}
