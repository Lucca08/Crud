package com.example.Crud.service;

import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Crud.model.Pessoa;
import com.example.Crud.repository.PessoaRepository;

import jakarta.transaction.Transactional;

@Service
public class AtualizarPessoaService {

    private static final Logger logger = Logger.getLogger(AtualizarPessoaService.class.getName());

    public static final String PESSOA_NAO_ENCONTRADA = "Pessoa não encontrada";

    @Autowired
    private PessoaRepository pessoaRepository;

    @Transactional
    public Pessoa atualizarPessoa(Long pessoaId, Pessoa pessoa) {
        logger.info("Atualizando pessoa {} com os dados: {}" + pessoaId + pessoa);
        Optional<Pessoa> pessoaOptional = pessoaRepository.findById(pessoaId);
        return pessoaOptional.map(p -> {
            p.setNome(pessoa.getNome());
            p.setDataNascimento(pessoa.getDataNascimento());
            p.setCpf(pessoa.getCpf());
            return pessoaRepository.save(p);
        }).orElseThrow(() -> new RuntimeException(PESSOA_NAO_ENCONTRADA));
    }
}
