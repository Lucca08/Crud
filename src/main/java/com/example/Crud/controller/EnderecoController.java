package com.example.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud.model.Endereco;
import com.example.crud.model.Pessoa;
import com.example.crud.service.AtualizaEndereco.AtualizaEnderecoPessoaService;

@RestController
public class EnderecoController {

    @Autowired
    private AtualizaEnderecoPessoaService atualizaEnderecoService;

    @PutMapping("/pessoa/{pessoaId}/endereco")
    public ResponseEntity<String> atualizarEnderecoPessoa(@PathVariable Long pessoaId, @RequestBody List<Endereco> novosEnderecos) {
        try {
            Pessoa pessoaAtualizada = atualizaEnderecoService.atualizarEnderecoPessoa(pessoaId, novosEnderecos);
            return ResponseEntity.ok("Endereços atualizados para a pessoa com ID: " + pessoaAtualizada.getId());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Erro: " + e.getMessage());
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao atualizar endereços da pessoa: " + e.getMessage());
        }
    }
}
