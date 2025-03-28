package com.example.ComunidadGamer.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ComunidadGamer.model.Receta;
import com.example.ComunidadGamer.service.RecetaService;

@RestController
@RequestMapping("/api/recetas")
public class RecetaController {
    private final RecetaService recetaService;

    public RecetaController(RecetaService recetaService) {
        this.recetaService = recetaService;
    }

    @GetMapping
    public ResponseEntity<List<Receta>> obtenerTodasLasRecetas() {
        return ResponseEntity.ok(recetaService.obtenerTodasLasRecetas());
    }

    @PostMapping
    public ResponseEntity<Receta> crearReceta(@RequestBody Receta receta) {
        return ResponseEntity.ok(recetaService.guardarReceta(receta));
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Receta>> buscarRecetas(@RequestParam(required = false) String nombre, @RequestParam(required = false) String dificultad) {
        if (nombre != null) {
            return ResponseEntity.ok(recetaService.buscarPorNombre(nombre));
        } else if (dificultad != null) {
            return ResponseEntity.ok(recetaService.buscarPorDificultad(dificultad));
        }
        return ResponseEntity.badRequest().build();
    }
}