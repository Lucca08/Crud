package com.example.Crud.service;

import java.util.List;

import java.util.Optional;
import java.util.logging.Logger;

import org.checkerframework.checker.units.qual.A;
import org.hibernate.internal.util.collections.ConcurrentReferenceHashMap.Option;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.Crud.model.Endereco;
import com.example.Crud.model.Pessoa;
import com.example.Crud.repository.PessoaRepository;

import jakarta.transaction.Transactional;

public class PessoaService {

    private static final Logger logger = Logger.getLogger(PessoaService.class.getName());

    public static final String PESSOA_NAO_ENCONTRADA = "Pessoa nao encontrada";

    
    @Autowired
    private PessoaRepository pessoaRepository;

    @Transactional
    public Pessoa criaPessoa(Pessoa pessoa, List<Endereco> enderecos){
        pessoa.setEnderecos(enderecos);
        logger.info("Criando pessoa {}:" + pessoa);
        return pessoaRepository.save(pessoa);
    }


    @Transactional
    public Pessoa atualizarPessoa(Long pessoaId, Pessoa pessoa) {
        logger.info("Atualizando pessoa {}:" + pessoaId + " com os dados: " + pessoa);
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
        logger.info("Deletando pessoa com id {}:" + pessoaId);
        Optional<Pessoa> pessoaOptional = pessoaRepository.findById(pessoaId);
        return pessoaOptional.map(p -> {
                pessoaRepository.delete(p);
                return p;
            })
            .orElseThrow(() -> new RuntimeException(PESSOA_NAO_ENCONTRADA));
    }

    @Transactional
    public Pessoa buscarPessoa(Long pessoaId) {
        logger.info("Buscando pessoa com id {}:" + pessoaId);
        Optional<Pessoa> pessoaOptional = pessoaRepository.findById(pessoaId);
        return pessoaOptional.orElseThrow(() -> new RuntimeException(PESSOA_NAO_ENCONTRADA));
    }

    @Transactional
    public List<Pessoa> buscarTodasPessoas() {
        logger.info("Buscando todas as pessoas");
        return pessoaRepository.findAll();
    }

    @Transactional
    public Pessoa atualizarEnderecoPessoa(Long pessoaId, List<Endereco> novosEnderecos) {
    logger.info("Atualizando enderecos da pessoa com id {}:" + pessoaId);
    Optional<Pessoa> pessoaOptional = pessoaRepository.findById(pessoaId);
    
    return pessoaOptional.map(p -> {
            Endereco.removerTodosEnderecosDaPessoa(p);
            p.getEnderecos().addAll(novosEnderecos);
            return pessoaRepository.save(p);
        })
        .orElseThrow(() -> new RuntimeException(PESSOA_NAO_ENCONTRADA));
    }

 


  

  
    






}
