package com.example.Crud.Stub;

import com.example.Crud.model.Pessoa;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.boot.autoconfigure.web.format.DateTimeFormatters;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.datetime.DateTimeFormatAnnotationFormatterFactory;
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
    


}
