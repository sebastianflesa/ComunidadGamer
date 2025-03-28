package com.example.ComunidadGamer.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ComunidadGamer.model.Receta;
import com.example.ComunidadGamer.repository.RecetaRepository;

@Service
public class RecetaService {
    private final RecetaRepository recetaRepository;

    public RecetaService(RecetaRepository recetaRepository) {
        this.recetaRepository = recetaRepository;
    }

    public List<Receta> obtenerTodasLasRecetas() {
        return recetaRepository.findAll();
    }

    public Receta guardarReceta(Receta receta) {
        return recetaRepository.save(receta);
    }

    public List<Receta> buscarPorNombre(String nombre) {
        return recetaRepository.findByNombreContainingIgnoreCase(nombre);
    }

    public List<Receta> buscarPorDificultad(String dificultad) {
        return recetaRepository.findByDificultadIgnoreCase(dificultad);
    }
}