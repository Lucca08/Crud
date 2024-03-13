package com.example.Crud.ServiceTest.CriaPessoaServiceTest;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.example.Crud.model.Endereco;
import com.example.Crud.model.Pessoa;
import com.example.Crud.repository.PessoaRepository;
import com.example.Crud.service.CriarPessoa.CriaPessoaService;

import jakarta.inject.Inject;

public class CriaPessoaServiceTest {
    
    @Mock
    private PessoaRepository pessoaRepository;
    
    @InjectMocks
    private CriaPessoaService criaPessoaService;
    
    @Test
    public void testCriaPessoaComSucesso() {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("rodrigo");
        pessoa.setCpf("24353254325");
        
        Endereco endereco = new Endereco();
        endereco.setRua("Rua");
        endereco.setNumero("Numero");
    }
}
