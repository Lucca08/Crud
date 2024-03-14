package com.example.Crud.ServiceTest.DeletarPessoaServiceTest;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.Crud.Stub.PessoaStub;
import com.example.Crud.model.Pessoa;
import com.example.Crud.repository.PessoaRepository;
import com.example.Crud.service.DeletarPessoa.DeletaPessoaService;

public class DeletarPessoaServiceTest {
    @Mock
    private PessoaRepository pessoaRepository;
    
    @InjectMocks
    private DeletaPessoaService deletarPessoaService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testDeletarPessoaComSucesso() {
        Pessoa pessoa = PessoaStub.pessoaTest4();
        when(pessoaRepository.findById(pessoa.getId())).thenReturn(Optional.empty());
        
        assertThrows(RuntimeException.class, () -> {
            deletarPessoaService.deletarPessoa(pessoa.getId());
        });
    }

    @Test
    public void testDeletarPessoaWithValidId() {
        Pessoa pessoa = PessoaStub.criarPessoa(1L);

        when(pessoaRepository.findById(1L)).thenReturn(Optional.of(pessoa));

        deletarPessoaService.deletarPessoa(1L);
    }

    @Test
    public void testDeletarPessoaWithInvalidId() {
        when(pessoaRepository.findById(999L)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> {
            deletarPessoaService.deletarPessoa(999L);
        });
    }
    

    
}
