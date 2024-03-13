package com.example.Crud.service.VerificaPessoa;

import java.time.LocalDate;
import java.time.Period;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Crud.model.Pessoa;
import com.example.Crud.repository.PessoaRepository;

import jakarta.transaction.Transactional;

@Service
public class VerificaIdadePessoaService {

    private static final Logger logger = Logger.getLogger(VerificaIdadePessoaService.class.getName());

    public static final String PESSOA_NAO_ENCONTRADA = "Pessoa não encontrada";

    @Autowired
    private PessoaRepository pessoaRepository;

    @Transactional
    public Pessoa verIdadePessoa(Long pessoaId) {
        if (pessoaId == null || pessoaId <= 0) {
            throw new IllegalArgumentException("ID da pessoa é obrigatório e deve ser maior que zero. ID inválido: " + pessoaId);
        }

        logger.info("Verificando idade da pessoa com ID: " + pessoaId);
        Pessoa pessoa = pessoaRepository.findById(pessoaId)
                                        .orElseThrow(() -> new RuntimeException(PESSOA_NAO_ENCONTRADA + " ID: " + pessoaId));
        LocalDate dataNascimento = LocalDate.parse(pessoa.getDataNascimento());
        int idade = calcularIdade(dataNascimento);
        pessoa.setDataNascimento(String.valueOf(idade));
        return pessoaRepository.save(pessoa);
    }

    private int calcularIdade(LocalDate dataNascimento) {
        LocalDate dataAtual = LocalDate.now();
        return Period.between(dataNascimento, dataAtual).getYears();
    }
}
