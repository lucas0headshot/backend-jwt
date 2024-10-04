package com.lucas.jwt.resources;

import com.lucas.jwt.dtos.UsuarioResponse;
import com.lucas.jwt.models.domain.Usuario;
import com.lucas.jwt.services.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController extends AbstractController {
    private final UsuarioService service;


    @PostMapping
    public ResponseEntity salvar(@RequestBody Usuario entidade) {
        return ResponseEntity.created(URI.create("/api/usuarios/" + entidade.getId())).body(service.salvar(entidade));
    }


    @PostMapping("/entrar")
    public ResponseEntity entrar(@RequestBody Usuario entidade) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.entrar(entidade));
    }


    @GetMapping
    public ResponseEntity<List<UsuarioResponse>> getAll() {
        return ResponseEntity.ok(service.listAllUsuarios());
    }


    @PreAuthorize("isAuthenticated()")
    @GetMapping("{login}")
    public ResponseEntity<Usuario> byLogin(@PathVariable("login") String login) {
        return ResponseEntity.ok().body(service.findByLogin(login));
    }
}
