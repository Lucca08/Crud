package com.example.Crud.service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Crud.model.Endereco;
import com.example.Crud.model.Pessoa;
import com.example.Crud.repository.PessoaRepository;

import jakarta.transaction.Transactional;

@Service
public class AtualizaEnderecoPessoaService {

    private static final Logger logger = Logger.getLogger(AtualizaEnderecoPessoaService.class.getName());

    public static final String PESSOA_NAO_ENCONTRADA = "Pessoa não encontrada";

    @Autowired
    private PessoaRepository pessoaRepository;

    @Transactional
    public Pessoa atualizarEnderecoPessoa(Long pessoaId, List<Endereco> novosEnderecos) {
        logger.info("Atualizando endereços da pessoa com id {}" + pessoaId);
        Optional<Pessoa> pessoaOptional = pessoaRepository.findById(pessoaId);
        return pessoaOptional.map(p -> {
            Endereco.removerTodosEnderecosDaPessoa(p);
            p.getEnderecos().addAll(novosEnderecos);
            return pessoaRepository.save(p);
        }).orElseThrow(() -> new RuntimeException(PESSOA_NAO_ENCONTRADA));
    }
}
