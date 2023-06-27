package com.example.exercicio1jpa.service;

import com.example.exercicio1jpa.entity.Usuario;
import com.example.exercicio1jpa.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    public Usuario salvarUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

}
