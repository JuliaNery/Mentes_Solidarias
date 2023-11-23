package com.globalsolution.mentessolidarias.controller.usuario.login;

import com.globalsolution.mentessolidarias.controller.usuario.dto.DadosDetalhamentoUsuario;
import com.globalsolution.mentessolidarias.controller.usuario.dto.DadosLogin;
import com.globalsolution.mentessolidarias.repositories.usuario.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/login")
public class LoginController {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @PostMapping
    @Transactional
    public ResponseEntity login(@RequestBody @Valid DadosLogin dados){
        var usuario = usuarioRepository.getReferenceByCpfAndSenha(dados.cpf(), dados.senha());
        return ResponseEntity.ok(new DadosDetalhamentoUsuario(usuario));
    }
}
