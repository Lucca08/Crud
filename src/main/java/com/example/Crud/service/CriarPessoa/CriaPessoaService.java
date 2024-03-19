package com.example.crud.service.CriarPessoa;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.crud.model.Endereco;
import com.example.crud.model.Pessoa;
import com.example.crud.repository.PessoaRepository;




@Service
public class CriaPessoaService {

    private static final Logger logger = Logger.getLogger(CriaPessoaService.class.getName());

    @Autowired
    private PessoaRepository pessoaRepository;

    @Transactional
    public Pessoa criaPessoa(Pessoa pessoa) {
        if (pessoa.getNome() == null || pessoa.getNome().isEmpty()) {
            throw new IllegalArgumentException("Nome da pessoa e obrigatorio");
        }
        
        if (pessoa.getCpf() == null || pessoa.getCpf().isEmpty()) {
            throw new IllegalArgumentException("CPF da pessoa e obrigatorio");
        }

        if(pessoaRepository.existsByCpf(pessoa.getCpf())){
            throw new IllegalArgumentException("Ja existe uma pessoa com o CPF informado");
        }

        // if(!enderecos.contains(enderecoPrincipal)){
        //     throw new IllegalArgumentException("O endereco principal deve estar na lista de enderecos da pessoa");
        // }
    
        // pessoa.setEnderecos(enderecos);
        // pessoa.setEnderecoPrincipal(enderecoPrincipal);


        logger.info("Criando pessoa com os dados: " + pessoa);
        return pessoaRepository.save(pessoa);
    }
}
