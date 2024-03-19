package com.example.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.crud.dto.CriaPessoaDTO;
import com.example.crud.model.Pessoa;
import com.example.crud.service.AtualizaPessoa.AtualizarPessoaService;
import com.example.crud.service.BuscarPessoa.BuscarPessoaService;
import com.example.crud.service.CriarPessoa.CriaPessoaService;
import com.example.crud.service.DeletarPessoa.DeletaPessoaService;
import com.example.crud.service.VerificaPessoa.VerificaIdadePessoaService;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private BuscarPessoaService listarPessoasService;

    @Autowired
    private CriaPessoaService criarPessoaService;

    @Autowired
    private AtualizarPessoaService atualizarPessoaService;

    @Autowired
    private DeletaPessoaService deletarPessoaService;

    @Autowired
    private VerificaIdadePessoaService verificaIdadePessoaService;

    @PostMapping
    public ResponseEntity<Pessoa> criaPessoa(@RequestBody CriaPessoaDTO pessoaDTO) {

        Pessoa createdPessoa = criarPessoaService.criaPessoa(pessoaDTO);
        return new ResponseEntity<>(createdPessoa, HttpStatus.CREATED);
    }

    
    @GetMapping
    public ResponseEntity<List<Pessoa>> buscarTodasPessoas() {
        List<Pessoa> pessoas = listarPessoasService.buscarTodasPessoas();
        return new ResponseEntity<>(pessoas, HttpStatus.OK);
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> buscarPessoaByid(@PathVariable Long id) {
        Pessoa pessoa = listarPessoasService.buscarPessoa(id);
        return new ResponseEntity<>(pessoa, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pessoa> atualizaPessoa(@PathVariable Long id, @RequestBody Pessoa pessoa) {
        Pessoa updatedPessoa = atualizarPessoaService.atualizarPessoa(id, pessoa);
        return new ResponseEntity<>(updatedPessoa, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletaPessoa(@PathVariable Long id) {
        deletarPessoaService.deletarPessoa(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}/verificar-idade") 
    public ResponseEntity<Pessoa> verificarIdadePessoa(@PathVariable Long id) {
        Pessoa pessoa = verificaIdadePessoaService.verIdadePessoa(id);
        return new ResponseEntity<>(pessoa, HttpStatus.OK);
    }
}
