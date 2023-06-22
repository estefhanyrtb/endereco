package com.example.exercicio1jpa.controller;

import com.example.exercicio1jpa.entity.Endereco;
import com.example.exercicio1jpa.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class EnderecoController {
    @Autowired
    private EnderecoService enderecoService;

    @PostMapping("endereco")
    public ResponseEntity<Endereco> salvarEndereco(@RequestBody Endereco endereco) {
        return ResponseEntity.status(HttpStatus.CREATED).body(enderecoService.salvarEndereco(endereco));
    }

    @GetMapping("endereco/{id}")
    public ResponseEntity<Endereco> buscarEndereco(@PathVariable Long id) {
        Endereco endereco = enderecoService.buscarEndereco(id);
        if (endereco == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, " Endereco não encontrado");
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(endereco);
        }
    }

    @GetMapping("enderecos")
    public ResponseEntity<List<Endereco>> buscarEnderecos() {
        return ResponseEntity.status(HttpStatus.OK).body(enderecoService.buscarEnderecos());
    }


    @PutMapping("atualizar")
    public ResponseEntity<Endereco> atualizarEndereco(@RequestBody Endereco endereco) {
        return ResponseEntity.status(HttpStatus.OK).body(enderecoService.atualizarEndereco(endereco));
    }


    @DeleteMapping("endereco/{id}")
    public ResponseEntity<String> apagarEndereco(@PathVariable Long id) {
        try {
            enderecoService.apagarEndereco(id);
            return ResponseEntity.status(HttpStatus.OK).body("Time com id " + id + " Endereco excluído com sucesso!");
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

    @GetMapping("endereco/cidade/{cidade}")
    public ResponseEntity<Endereco> buscarEnderecoPorCidade(@PathVariable String cidade) {
        return ResponseEntity.status(HttpStatus.OK).body(enderecoService.buscarEnderecoPorCidade(cidade));
    }

    @GetMapping("endereco/cep/{cep}")
    public ResponseEntity<Endereco> buscarEnderecoPorCep(@PathVariable String cep) {
        return ResponseEntity.status(HttpStatus.OK).body(enderecoService.buscarEnderecoPorCep(cep));
    }

    @GetMapping("endereco/rua/{rua}")
    public ResponseEntity<Endereco> buscarEnderecoPorRua (@PathVariable String rua) {
        return ResponseEntity.status(HttpStatus.OK).body(enderecoService.buscarEnderecoPorRua(rua));
    }
}



