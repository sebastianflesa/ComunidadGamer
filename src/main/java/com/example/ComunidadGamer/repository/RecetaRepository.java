package com.example.ComunidadGamer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ComunidadGamer.model.Receta;

public interface RecetaRepository extends JpaRepository<Receta, Long> {
    List<Receta> findByNombreContainingIgnoreCase(String nombre);
    List<Receta> findByDificultadIgnoreCase(String dificultad);

}