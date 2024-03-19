// package com.example.Crud.ServiceTest.CriaPessoaServiceTest;
// import static org.junit.jupiter.api.Assertions.assertThrows;
// import static org.mockito.ArgumentMatchers.any;
// import static org.mockito.Mockito.verify;
// import static org.mockito.Mockito.when;

// import java.util.ArrayList;
// import java.util.List;

// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import org.mockito.MockitoAnnotations;

// import com.example.Crud.Stub.EnderecoStub;
// import com.example.Crud.Stub.PessoaStub;
// import com.example.crud.model.Endereco;
// import com.example.crud.model.Pessoa;
// import com.example.crud.repository.PessoaRepository;
// import com.example.crud.service.CriarPessoa.CriaPessoaService;

// public class CriaPessoaServiceTest {

//     @Mock
//     private PessoaRepository pessoaRepository;

//     @InjectMocks
//     private CriaPessoaService criaPessoaService;

//     @BeforeEach
//     public void setUp() {
//         MockitoAnnotations.openMocks(this);
//     }

//     @Test
//     public void testCriaPessoaComSucesso() {
//         Pessoa pessoa = PessoaStub.pessoaTest();
//         Endereco endereco = EnderecoStub.enderecoTest();

//         List<Endereco> enderecos = new ArrayList<>();
//         enderecos.add(endereco);

//         pessoa.setEnderecos(enderecos);
//         pessoa.setEnderecoPrincipal(endereco);

//         when(pessoaRepository.existsByCpf("24353254325")).thenReturn(false);
//         when(pessoaRepository.save(any(Pessoa.class))).thenReturn(pessoa);

//         Pessoa pessoaCriada = criaPessoaService.criaPessoa(PessoaStub.criaPessoaDTO());

//         verify(pessoaRepository).existsByCpf("24353254325");
//         verify(pessoaRepository).save(any(Pessoa.class));
//     }

//     @Test
//     public void testCriaPessoaComDadosInvalidos() {
//         Pessoa pessoa2 = PessoaStub.pessoaTest2();

//         assertThrows(IllegalArgumentException.class, () -> {
//             criaPessoaService.criaPessoa(PessoaStub.criaPessoaDTO2());
//         });
//     }

//     @Test
//     public void testCriaPessoaComCpfJaExistente() {
//         Pessoa pessoa = PessoaStub.pessoaTest3();
//         Endereco endereco = EnderecoStub.enderecoTest3();

//         List<Endereco> enderecos = new ArrayList<>();
//         enderecos.add(endereco);

//         pessoa.setEnderecos(enderecos);
//         pessoa.setEnderecoPrincipal(endereco);

//         when(pessoaRepository.existsByCpf("53156423534")).thenReturn(true);

//         assertThrows(IllegalArgumentException.class, () -> {
//             criaPessoaService.criaPessoa(PessoaStub.criaPessoaDTO3());
//         });
//     }
// }
