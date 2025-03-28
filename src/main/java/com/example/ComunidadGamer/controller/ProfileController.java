package com.example.ComunidadGamer.controller;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ComunidadGamer.model.Usuario;
import com.example.ComunidadGamer.service.UsuarioService;

@RestController
@RequestMapping("/api/perfil")
public class ProfileController {
    private final UsuarioService usuarioService;

    public ProfileController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity<?> verPerfil(@AuthenticationPrincipal UserDetails userDetails) {
        Optional<Usuario> usuario = usuarioService.buscarPorUsername(userDetails.getUsername());
        return usuario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping
    public ResponseEntity<?> actualizarPerfil(@AuthenticationPrincipal UserDetails userDetails,
            @RequestBody Usuario usuarioActualizado) {
        Optional<Usuario> usuarioOptional = usuarioService.buscarPorUsername(userDetails.getUsername());
        if (usuarioOptional.isPresent()) {
            Usuario usuario = usuarioOptional.get();
            usuario.setUsername(usuarioActualizado.getUsername());
            usuario.setEmail(usuarioActualizado.getEmail());
            usuarioService.save(usuario);
            return ResponseEntity.ok("Perfil actualizado exitosamente");
        }
        return ResponseEntity.notFound().build();
    }
}