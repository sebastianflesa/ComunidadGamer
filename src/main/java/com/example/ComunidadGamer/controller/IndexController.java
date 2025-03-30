package com.example.ComunidadGamer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.ComunidadGamer.model.Receta;
import com.example.ComunidadGamer.service.RecetaService;

@Controller
public class IndexController {

    @Autowired
    private RecetaService recetaService;

    @GetMapping("/")
    public String indexPage(Model model) {
        List<Receta> recetas = recetaService.obtenerTodasLasRecetas();
        model.addAttribute("recetas", recetas);
        return "index";
    }
    
    @GetMapping("/login")
    public String mostrarLogin() {
        return "login";
    }

    @GetMapping("/registro")
    public String registroPage() {
        return "register";
    }
    
}