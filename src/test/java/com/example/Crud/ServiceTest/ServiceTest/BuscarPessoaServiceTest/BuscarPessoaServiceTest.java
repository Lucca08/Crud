package com.example.Crud.ServiceTest.ServiceTest.BuscarPessoaServiceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.Crud.Stub.PessoaStub;
import com.example.crud.model.Pessoa;
import com.example.crud.repository.PessoaRepository;
import com.example.crud.service.BuscarPessoa.BuscarPessoaService;

public class BuscarPessoaServiceTest {
    
    @Mock
    private PessoaRepository pessoaRepository;
    
    @InjectMocks
    private BuscarPessoaService buscarPessoaService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testBuscarPessoaComSucesso() {
        
        Pessoa pessoaStub = PessoaStub.pessoaTest();
        when(pessoaRepository.findById(anyLong())).thenReturn(Optional.of(pessoaStub));

        Pessoa pessoaEncontrada = buscarPessoaService.buscarPessoa(1L);
        assertEquals(pessoaStub, pessoaEncontrada);
    }

    @Test
    public void testBuscarTodasPessoasComSucesso(){
        List<Pessoa> pessoasStub = Arrays.asList(PessoaStub.pessoaTest(), PessoaStub.pessoaTest2());
        when(pessoaRepository.findAll()).thenReturn(pessoasStub);

        List<Pessoa> pessoasEncontradas = buscarPessoaService.buscarTodasPessoas();
        assertEquals(pessoasStub, pessoasEncontradas);
        
    }



}
