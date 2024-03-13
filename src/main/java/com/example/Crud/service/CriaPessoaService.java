package com.example.Crud.service;

import java.util.List;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionalEventListener;

import com.example.Crud.model.Endereco;
import com.example.Crud.model.Pessoa;
import com.example.Crud.repository.PessoaRepository;

@Service
public class CriaPessoaService {

    private static final Logger logger = Logger.getLogger(CriaPessoaService.class.getName());

    @Autowired
    private PessoaRepository pessoaRepository;

    @TransactionalEventListener
    public Pessoa criaPessoa(Pessoa pessoa, List<Endereco> enderecos) {
        pessoa.setEnderecos(enderecos);
        logger.info("Criando pessoa {}: {}" + pessoa.getId() + pessoa);
        return pessoaRepository.save(pessoa);
    }
}
