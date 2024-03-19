package com.example.crud.service.DeletarPessoa;

import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crud.model.Pessoa;
import com.example.crud.repository.PessoaRepository;

import jakarta.transaction.Transactional;

@Service
public class DeletaPessoaService {

    private static final Logger logger = Logger.getLogger(DeletaPessoaService.class.getName());

    public static final String PESSOA_NAO_ENCONTRADA = "Pessoa não encontrada";

    @Autowired
    private PessoaRepository pessoaRepository;

    @Transactional
    public Pessoa deletarPessoa(Long pessoaId) {
        logger.info("Deletando pessoa com ID: " + pessoaId);
        Optional<Pessoa> pessoaOptional = pessoaRepository.findById(pessoaId);
        return pessoaOptional.map(p -> {
            pessoaRepository.delete(p);
            return p;
        }).orElseThrow(() -> new RuntimeException(PESSOA_NAO_ENCONTRADA + " ID: " + pessoaId));
    }
}
