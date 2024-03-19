package com.example.crud.service.BuscarPessoa;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crud.model.Pessoa;
import com.example.crud.repository.PessoaRepository;



@Service
public class BuscarPessoaService {

    private static final Logger logger = Logger.getLogger(BuscarPessoaService.class.getName());

    @Autowired
    private PessoaRepository pessoaRepository;

    public Pessoa buscarPessoa(Long pessoaId) {
        if(pessoaId == null || pessoaId <= 0){
            throw new IllegalArgumentException("Id da pessoa e obrigatorio e deve ser maior que zero, id invalido: "+ pessoaId);
        }
        logger.info("Buscando pessoa com id {}" + pessoaId);
        return pessoaRepository.findById(pessoaId)
                               .orElseThrow(() -> new RuntimeException("Pessoa nao encontrada com ID: " + pessoaId));
    }

    public List<Pessoa> buscarTodasPessoas() {
        logger.info("Buscando todas as pessoas");
        return pessoaRepository.findAll();
    }
}
