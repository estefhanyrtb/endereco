package com.example.exercicio1jpa.controller;


import com.example.exercicio1jpa.entity.Usuario;

import com.example.exercicio1jpa.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/v1")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("usuario")
    public ResponseEntity<Usuario> salvarUsuario(@RequestBody Usuario usuario) {
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.salvarUsuario(usuario));
    }
}
