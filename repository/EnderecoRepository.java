package com.example.exercicio1jpa.repository;

import com.example.exercicio1jpa.entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
    Endereco findByCidade(String cidade);
    Endereco findByCep(String cep);
    Endereco findByRua(String rua);

}

