package com.example.Crud.ServiceTest.AtualizarEnderecoPessoaService;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.Crud.Stub.EnderecoStub;
import com.example.Crud.Stub.PessoaStub;
import com.example.crud.model.Endereco;
import com.example.crud.model.Pessoa;
import com.example.crud.repository.PessoaRepository;
import com.example.crud.service.AtualizaEndereco.AtualizaEnderecoPessoaService;

public class AtualizaEnderecoPessoaServiceTest {
    
    @Mock
    private PessoaRepository pessoaRepository;
    
    @InjectMocks
    private AtualizaEnderecoPessoaService atualizaEnderecoPessoaService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAtualizarEnderecoPessoaComSucesso() {
        Pessoa pessoaExistente = PessoaStub.pessoaTest(); 
        List<Endereco> novosEnderecos = Arrays.asList(EnderecoStub.enderecoTest(), EnderecoStub.enderecoTest2());
        when(pessoaRepository.findById(anyLong())).thenReturn(Optional.of(pessoaExistente));
        when(pessoaRepository.save(pessoaExistente)).thenReturn(pessoaExistente);
    
        Pessoa pessoaAtualizada = atualizaEnderecoPessoaService.atualizarEnderecoPessoa(1L, novosEnderecos);
    
        assertNotNull(pessoaAtualizada);
        assertEquals(novosEnderecos, pessoaAtualizada.getEnderecos());
    }
    
    @Test
    public void testAtualizarEnderecoPessoaPessoaNaoEncontrada() {
        when(pessoaRepository.findById(anyLong())).thenReturn(Optional.empty());

        List<Endereco> novosEnderecos = Arrays.asList(
            EnderecoStub.enderecoTest(),
            EnderecoStub.enderecoTest2()
        );

        assertThrows(RuntimeException.class, () -> {
            atualizaEnderecoPessoaService.atualizarEnderecoPessoa(1L, novosEnderecos);
        });
    }
}
