package com.example.crud.service.AtualizaEndereco;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crud.model.Endereco;
import com.example.crud.model.Pessoa;
import com.example.crud.repository.PessoaRepository;

import jakarta.transaction.Transactional;

@Service
public class AtualizaEnderecoPessoaService {

    private static final Logger logger = Logger.getLogger(AtualizaEnderecoPessoaService.class.getName());

    public static final String PESSOA_NAO_ENCONTRADA = "Pessoa não encontrada";

    @Autowired
    private PessoaRepository pessoaRepository;

    @Transactional
    public Pessoa atualizarEnderecoPessoa(Long pessoaId, List<Endereco> novosEnderecos) {
    if (novosEnderecos == null || novosEnderecos.isEmpty()) {
        throw new IllegalArgumentException("A lista de novos enderecos nao pode ser nula ou vazia");
    }

    logger.info("Atualizando endereços da pessoa com ID: " + pessoaId);
    Optional<Pessoa> pessoaOptional = pessoaRepository.findById(pessoaId);
    return pessoaOptional.map(pessoa -> {
        if (pessoa.getEnderecos() == null) {
            pessoa.setEnderecos(new ArrayList<>()); // Inicializa a lista de endereços se for nula
        }
        pessoa.getEnderecos().addAll(novosEnderecos); // Adiciona os novos endereços
        return pessoaRepository.save(pessoa);
    }).orElseThrow(() -> new RuntimeException(PESSOA_NAO_ENCONTRADA + " ID: " + pessoaId));
 }
}