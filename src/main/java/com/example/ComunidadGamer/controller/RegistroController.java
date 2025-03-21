package com.example.ComunidadGamer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ComunidadGamer.model.RegistroRequest;
import com.example.ComunidadGamer.service.RegistroService;


@RestController
@RequestMapping("/api/auth")
public class RegistroController {
    @Autowired
    private RegistroService registroService;

    @PostMapping("/registro")
    public ResponseEntity<?> registro(@RequestBody RegistroRequest registroRequest){
        registroService.registrarUsuario(registroRequest);
        return ResponseEntity.ok("Usuario registrado correctamente");
    }
    
    
}
