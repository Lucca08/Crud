package com.example.Crud.Stub;

import com.example.Crud.model.Endereco;

public class EnderecoStub {
    public static Endereco enderecoTest(){
        Endereco endereco = new Endereco();
        endereco.setRua("Rua dos lagos");
        endereco.setNumero("812");
        endereco.setBairro("Centro");
        endereco.setCidade("São Paulo");
        endereco.setEstado("SP");
        endereco.setCep("12345678");
        return endereco;
    }

    public static Endereco enderecoTest2(){
        Endereco endereco = new Endereco();
        endereco.setRua("Rua das flores");
        endereco.setNumero("34");
        endereco.setBairro("Cidade Nova");
        endereco.setCidade("Belo Horizonte");
        endereco.setEstado("MG");
        endereco.setCep("23456789");
        return endereco;
    }

    public static Endereco enderecoTest3(){
        Endereco endereco = new Endereco();
        endereco.setRua("Rua das dores");
        endereco.setNumero("432");
        endereco.setBairro("Centro");
        endereco.setCidade("Porto Alegre");
        endereco.setEstado("RS");
        endereco.setCep("43245678");
        return endereco;
    }
}
