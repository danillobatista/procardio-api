package br.com.procardio.api.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.procardio.api.dto.UsuarioDTO;
import br.com.procardio.api.model.Usuario;
import br.com.procardio.api.service.UsuarioService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    public ResponseEntity<Usuario> cadastrarUsuario(@Valid @RequestBody UsuarioDTO usuarioDTO) {
        Usuario novoUsuario = usuarioService.salvarUsuario(usuarioDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoUsuario);
    }

    public ResponseEntity<Usuario> atualizarUsuario(@PathVariable Long id, @Valid @RequestBody UsuarioDTO usuarioDTO) {
        Usuario usuarioAtualizado = usuarioService.salvarUsuario(id, usuarioDTO);

        if (Objects.nonNull(usuarioAtualizado)) {
            return ResponseEntity.ok(usuarioAtualizado);
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<Usuario> buscarUsuarioPorId(@PathVariable Long id) {
        Usuario usuario = usuarioService.buscarUsuarioPorId(id);
        if (Objects.nonNull(usuario)) {
            return ResponseEntity.ok(usuario);
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<Usuario> buscarUsuarioPorEmail(@Valid @PathVariable String email) {
        Usuario usuario = usuarioService.buscarUsuarioPorEmail(email);
        if (Objects.nonNull(usuario)) {
            return ResponseEntity.ok(usuario);
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<List<Usuario>> buscarUsuariosPorNome(@Valid @PathVariable String nome) {
        List<Usuario> usuarios = usuarioService.buscarUsuariosPorNome(nome);
        if (Objects.nonNull(usuarios)) {
            return ResponseEntity.ok(usuarios);
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<List<Usuario>> listarUsuarios() {
        List<Usuario> usuarios = usuarioService.listarUsuarios();
        if (Objects.nonNull(usuarios)) {
            return ResponseEntity.ok(usuarios);
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<Void> deletarUsuario(@PathVariable Long id) {
        usuarioService.deletarUsuario(id);
        return ResponseEntity.noContent().build();
    }

}
