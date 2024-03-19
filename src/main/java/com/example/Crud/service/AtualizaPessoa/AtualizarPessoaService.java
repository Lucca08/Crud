package com.example.crud.service.AtualizaPessoa;

import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crud.model.Pessoa;
import com.example.crud.repository.PessoaRepository;

import jakarta.transaction.Transactional;

@Service
public class AtualizarPessoaService {

    private static final Logger logger = Logger.getLogger(AtualizarPessoaService.class.getName());

    public static final String PESSOA_NAO_ENCONTRADA = "Pessoa não encontrada";

    @Autowired
    private PessoaRepository pessoaRepository;

    @Transactional
    public Pessoa atualizarPessoa(Long pessoaId, Pessoa pessoa) {

        Optional<Pessoa> pessoaOptional = pessoaRepository.findById(pessoaId);
        Pessoa pessoaExistente = pessoaOptional.orElseThrow(() -> new RuntimeException(PESSOA_NAO_ENCONTRADA));


        logger.info("Atualizando pessoa " + pessoaId + " com os dados: " + pessoa);
  
        pessoaOptional.map(p -> {
            p.setNome(pessoa.getNome());
            p.setDataNascimento(pessoa.getDataNascimento());
            p.setCpf(pessoa.getCpf());
            return pessoaRepository.save(p);
        });

        return pessoaExistente;
    }
}
