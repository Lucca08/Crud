package com.example.Crud.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Crud.model.Pessoa;
import com.example.Crud.repository.PessoaRepository;

@Service
public class BuscarPessoaService {

    private static final Logger logger = Logger.getLogger(BuscarPessoaService.class.getName());

    @Autowired
    private PessoaRepository pessoaRepository;

    public Pessoa buscarPessoa(Long pessoaId) {
        logger.info("Buscando pessoa com id {}" + pessoaId);
        return pessoaRepository.findById(pessoaId)
                               .orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));
    }

    public List<Pessoa> buscarTodasPessoas() {
        logger.info("Buscando todas as pessoas");
        return pessoaRepository.findAll();
    }
}
