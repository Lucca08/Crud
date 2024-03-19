package com.example.Crud.Stub;

import java.time.LocalDate;


import com.example.crud.model.Pessoa;
public class PessoaStub {
    public static Pessoa pessoaTest(){
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Lucia");
        pessoa.setCpf("24353254325");
        return pessoa;
    }

    public static Pessoa pessoaTest2(){
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("");
        pessoa.setCpf("");
        return pessoa;
    }

    public static Pessoa pessoaTest3(){
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Lucia");
        pessoa.setCpf("53156423534");
        return pessoa;
    }

    public static Pessoa pessoaTest4(){
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Ricardo");
        pessoa.setCpf("43534534534");
        pessoa.setId(1L);
        return pessoa;
    }

    public static Pessoa criarPessoa(Long id){
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Lucia");
        pessoa.setCpf("24353254325");
        pessoa.setId(id);
        return pessoa;
    }

    public static Pessoa pessoaTest5(){
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Lucia");
        pessoa.setCpf("24353254325");
        pessoa.setId(4L);
        pessoa.setDataNascimento(LocalDate.of(1990, 12, 12));
        return pessoa;
    }

    public static Pessoa pessoaTest6() {
        Pessoa pessoa = new Pessoa();
        pessoa.setId(1L);
        pessoa.setNome("João");
        pessoa.setDataNascimento(LocalDate.of(1980, 10, 15));
        pessoa.setCpf("12345678900");
        return pessoa;
    }
    


}
