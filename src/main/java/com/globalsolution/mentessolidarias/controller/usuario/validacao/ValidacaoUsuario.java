package com.globalsolution.mentessolidarias.controller.usuario.validacao;

import com.globalsolution.mentessolidarias.controller.usuario.dto.DadosCadastroUsuario;
import com.globalsolution.mentessolidarias.controller.usuario.dto.DadosDetalhamentoUsuario;
import com.globalsolution.mentessolidarias.entities.endereco.Endereco;
import com.globalsolution.mentessolidarias.entities.usuario.EscolaridadeEntity;
import com.globalsolution.mentessolidarias.entities.usuario.TipoUsuarioEntity;
import com.globalsolution.mentessolidarias.entities.usuario.UsuarioEntity;
import com.globalsolution.mentessolidarias.repositories.documentos.receita.MedicamentoRepository;
import com.globalsolution.mentessolidarias.repositories.documentos.receita.ReceitaMedicamentoRepository;
import com.globalsolution.mentessolidarias.repositories.documentos.receita.ReceitaRepository;
import com.globalsolution.mentessolidarias.repositories.usuario.EscolaridadeRepository;
import com.globalsolution.mentessolidarias.repositories.usuario.TipoUsuarioRepository;
import com.globalsolution.mentessolidarias.repositories.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidacaoUsuario {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EscolaridadeRepository escolaridadeRepository;

    @Autowired
    private TipoUsuarioRepository tipoUsuarioRepository;

    public DadosDetalhamentoUsuario cadastrar(DadosCadastroUsuario dados){

        var escolaridade =getEscolaridade(dados.idEscolaridade());
        var tipoUsuario = getTipoUsuario(dados.idTipoUsuario());


        var usuario = new UsuarioEntity(dados.cpf(), dados.nome(), dados.genero(), dados.telefone(), dados.dtNasc(),escolaridade,tipoUsuario,dados.email(),dados.senha(), new Endereco(dados.endereco()));
        usuarioRepository.save(usuario);
        return new DadosDetalhamentoUsuario(usuario);
    }
    public EscolaridadeEntity getEscolaridade(Long id){
        var escolaridade = escolaridadeRepository.getReferenceById(id);
        return escolaridade;
    }
    public TipoUsuarioEntity getTipoUsuario(Long id){
        var tipoUsuario = tipoUsuarioRepository.getReferenceById(id);
        return tipoUsuario;
    }
}
