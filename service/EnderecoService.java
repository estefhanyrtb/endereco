package com.example.exercicio1jpa.service;

import com.example.exercicio1jpa.entity.Endereco;
import com.example.exercicio1jpa.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository enderecoRepository;

    public Endereco salvarEndereco(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    public Endereco buscarEndereco(Long id) {
        return enderecoRepository.findById(id).get();

    }

    public List<Endereco> buscarEnderecos() {
        return enderecoRepository.findAll();
    }

    public Endereco atualizarEndereco(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    public void apagarEndereco(Long id) {
        if (enderecoRepository.existsById(id)) {
            enderecoRepository.deleteById(id);
        } else {
            throw new RuntimeException("não encontrado");
        }
    }

    public Endereco buscarEnderecoPorCidade(String cidade) {
        return enderecoRepository.findByCidade(cidade);
    }

    public Endereco buscarEnderecoPorCep(String cep) {
        return enderecoRepository.findByCep(cep);
    }
    public Endereco buscarEnderecoPorRua(String rua) {
        return enderecoRepository.findByRua(rua);
    }
}
