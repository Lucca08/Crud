package com.example.Crud.service;

import java.util.List;

import java.util.Optional;

import org.checkerframework.checker.units.qual.A;
import org.hibernate.internal.util.collections.ConcurrentReferenceHashMap.Option;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.Crud.model.Endereco;
import com.example.Crud.model.Pessoa;
import com.example.Crud.repository.PessoaRepository;

import jakarta.transaction.Transactional;

public class PessoaService {

    public static final String PESSOA_NAO_ENCONTRADA = "Pessoa nao encontrada";

    
    @Autowired
    private PessoaRepository pessoaRepository;

    @Transactional
    public Pessoa criaPessoa(Pessoa pessoa){
        return pessoaRepository.save(pessoa);
    }


    @Transactional
    public Pessoa atualizarPessoa(Long pessoaId, Pessoa pessoa) {
        Optional<Pessoa> pessoaOptional = pessoaRepository.findById(pessoaId);
        return pessoaOptional.map(p -> {
                p.setNome(pessoa.getNome());
                p.setDataNascimento(pessoa.getDataNascimento());
                p.setCpf(pessoa.getCpf());
                return pessoaRepository.save(p);
            })
            .orElseThrow(() -> new RuntimeException(PESSOA_NAO_ENCONTRADA));
    }

    @Transactional
    public Pessoa deletarPessoa(Long pessoaId) {
        Optional<Pessoa> pessoaOptional = pessoaRepository.findById(pessoaId);
        return pessoaOptional.map(p -> {
                pessoaRepository.delete(p);
                return p;
            })
            .orElseThrow(() -> new RuntimeException(PESSOA_NAO_ENCONTRADA));
    }

    @Transactional
    public Pessoa buscarPessoa(Long pessoaId) {
        Optional<Pessoa> pessoaOptional = pessoaRepository.findById(pessoaId);
        return pessoaOptional.orElseThrow(() -> new RuntimeException(PESSOA_NAO_ENCONTRADA));
    }

    @Transactional
    public List<Pessoa> buscarTodasPessoas() {
        return pessoaRepository.findAll();
    }

    @Transactional
    public Pessoa atualizarEnderecoPessoa(Long pessoaId, List<Endereco> novosEnderecos) {
    Optional<Pessoa> pessoaOptional = pessoaRepository.findById(pessoaId);
    
    return pessoaOptional.map(p -> {
            Endereco.removerTodosEnderecosDaPessoa(p);
            p.getEnderecos().addAll(novosEnderecos);
            return pessoaRepository.save(p);
        })
        .orElseThrow(() -> new RuntimeException(PESSOA_NAO_ENCONTRADA));
    }


  
    






}
