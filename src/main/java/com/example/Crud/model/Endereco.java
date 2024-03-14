package com.example.Crud.model;

import java.util.List;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.util.ArrayList;

@Entity
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String rua;

    private String numero;

    private String bairro;

    private String cidade;

    private String estado;

    private String cep;

    private String enderecoCompleto;

    private String enderecoPrincipal;

    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;

    public Endereco() {
    }

    public Endereco(String rua, String numero, String bairro, String cidade, String estado, String cep) {
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    
    public String getEnderecoCompleto() {
        return enderecoCompleto;
    }

    public void setEnderecoCompleto(String enderecoCompleto) {
        this.enderecoCompleto = enderecoCompleto;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    
    public static void removerTodosEnderecosDaPessoa(Pessoa pessoa) {
        List<Endereco> enderecos = pessoa.getEnderecos();
        for (Endereco endereco : new ArrayList<>(enderecos)) {
            enderecos.remove(endereco);
            endereco.setPessoa(null);
        }
    }

    @Override
    public String toString() {
        return "Endereco{id=" + id + ", rua='" + rua + "', numero='" + numero + "', bairro='" + bairro + "', cidade='" + cidade + "', estado='" + estado + "', cep='" + cep + "'}";
    }





}
