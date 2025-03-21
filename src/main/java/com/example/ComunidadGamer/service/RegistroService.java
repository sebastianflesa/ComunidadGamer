package com.example.ComunidadGamer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.ComunidadGamer.model.RegistroRequest;
import com.example.ComunidadGamer.model.Usuario;
import com.example.ComunidadGamer.repository.UsuarioRepository;

@Service
public class RegistroService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void registrarUsuario(RegistroRequest registroRequest){
        Usuario usuario = new Usuario();
        usuario.setEmail(registroRequest.getEmail());
        usuario.setPassword(passwordEncoder.encode(registroRequest.getPassword()));
        usuarioRepository.save(usuario);
    }
}
