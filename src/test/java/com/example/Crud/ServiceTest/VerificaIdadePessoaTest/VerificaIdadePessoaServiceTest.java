package com.example.Crud.ServiceTest.VerificaIdadePessoaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.Crud.Stub.PessoaStub;
import com.example.Crud.model.Pessoa;
import com.example.Crud.repository.PessoaRepository;
import com.example.Crud.service.VerificaPessoa.VerificaIdadePessoaService;

public class VerificaIdadePessoaServiceTest {

    @Mock
    private PessoaRepository pessoaRepository;

    @InjectMocks
    private VerificaIdadePessoaService verificaIdadePessoaService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testVerificarIdadePessoaComSucesso() {
        Pessoa pessoa = PessoaStub.pessoaTest5();
        when(pessoaRepository.findById(anyLong())).thenReturn(Optional.of(pessoa));
    
        Pessoa pessoaComIdade = verificaIdadePessoaService.verIdadePessoa(4L);
    
        assertNotNull(pessoaComIdade);
        assertNotNull(pessoaComIdade.getDataNascimento());
    }
    


    @Test
    public void testVerificarIdadePessoaComPessoaNaoEncontrada() {  
        when(pessoaRepository.findById(1L)).thenReturn(Optional.empty());
        
        assertThrows(RuntimeException.class, () -> {
            verificaIdadePessoaService.verIdadePessoa(1L);
        });
    }
}
