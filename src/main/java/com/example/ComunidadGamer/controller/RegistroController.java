package com.example.ComunidadGamer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ComunidadGamer.model.RegistroRequest;
import com.example.ComunidadGamer.service.RegistroService;


@Controller
@RequestMapping("/api/auth")
public class RegistroController {
    @Autowired
    private RegistroService registroService;

    @PostMapping
    public String registro(@ModelAttribute RegistroRequest registroRequest) {
        registroService.registrarUsuario(registroRequest);
        return "redirect:/login";
    }
    
    
}
