package com.example.ComunidadGamer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ComunidadGamer.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

    public Usuario findByEmail(String email);
}
