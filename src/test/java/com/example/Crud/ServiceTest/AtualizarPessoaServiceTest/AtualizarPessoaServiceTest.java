package com.example.Crud.ServiceTest.AtualizarPessoaServiceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.junit.jupiter.api.Assertions.assertThrows;


import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.Crud.Stub.PessoaStub;
import com.example.crud.model.Pessoa;
import com.example.crud.repository.PessoaRepository;
import com.example.crud.service.AtualizaPessoa.AtualizarPessoaService;

public class AtualizarPessoaServiceTest {
    
    @Mock
    private PessoaRepository pessoaRepository;
    
    @InjectMocks
    private AtualizarPessoaService atualizarPessoaService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAtualizarPessoaComSucesso() {
        Pessoa pessoaExistente = PessoaStub.pessoaTest6();

        when(pessoaRepository.findById(1L)).thenReturn(Optional.of(pessoaExistente));
        when(pessoaRepository.save(pessoaExistente)).thenReturn(pessoaExistente);

        Pessoa pessoaAtualizada = new Pessoa();
        pessoaAtualizada.setNome("José");
        pessoaAtualizada.setDataNascimento(LocalDate.of(1990, 5, 20));
        pessoaAtualizada.setCpf("98765432100");

        Pessoa pessoaAtualizadaResult = atualizarPessoaService.atualizarPessoa(1L, pessoaAtualizada);

        assertEquals("José", pessoaAtualizadaResult.getNome());
        assertEquals(LocalDate.of(1990, 5, 20), pessoaAtualizadaResult.getDataNascimento());
        assertEquals("98765432100", pessoaAtualizadaResult.getCpf());
    }

    @Test
    public void testAtualizarPessoaPessoaNaoEncontrada() {
        when(pessoaRepository.findById(anyLong())).thenReturn(Optional.empty());
        Pessoa pessoaAtualizada = new Pessoa();
        pessoaAtualizada.setNome("José");
        pessoaAtualizada.setDataNascimento(LocalDate.of(1990, 5, 20));
        pessoaAtualizada.setCpf("98765432100");
        
        assertThrows(RuntimeException.class, () -> {
            atualizarPessoaService.atualizarPessoa(1L, pessoaAtualizada);
        });
    }
}
