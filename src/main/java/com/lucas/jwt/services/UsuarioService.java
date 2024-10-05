package com.lucas.jwt.services;

import com.lucas.jwt.configs.TokenService;
import com.lucas.jwt.dtos.UsuarioResponse;
import com.lucas.jwt.models.domain.Usuario;
import com.lucas.jwt.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRepository repository;
    private final AuthenticationManager authManager;
    private final TokenService tokenService;
    private final EmailService emailService;


    public UsuarioResponse salvar(Usuario entidade) {
        var senha_criptografada = new BCryptPasswordEncoder().encode(entidade.getSenha());

        var usuario = new Usuario(entidade.getLogin(), senha_criptografada, entidade.getEmail());

        var salvo = repository.save(usuario);

        emailService.addEmail(usuario.getEmail());

        return new UsuarioResponse(salvo.getLogin());
    }


    public String entrar(Usuario usuario) {
        var usuario_senha = new UsernamePasswordAuthenticationToken(usuario.getLogin(), usuario.getSenha());
        var auth = authManager.authenticate(usuario_senha);
        return tokenService.gerarToken((Usuario) auth.getPrincipal());
    }


    public List<UsuarioResponse> listAllUsuarios(){
        var list =  repository.findAll();

        return list.stream()
                .map(usuario -> new UsuarioResponse(usuario.getLogin()))
                .toList();
    }


    public Usuario findByLogin(String login){
        return repository.findBylogin(login);
    }
}
