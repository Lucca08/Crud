package com.example.crud.model;

import com.example.crud.dto.CriaEnderecoDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor  
@Entity
@Getter
@Setter
public class Endereco {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String numero;
        
    @Column
    private String rua;

    @Column
    private String bairro;

    @Column
    private String cidade;

    @Column
    private String estado;

    @Column
    private String cep;

    @Column
    private String enderecoCompleto;

    @Column
    private boolean enderecoPrincipal;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;


    public Endereco(CriaEnderecoDTO enderecoDTO, Pessoa pessoaEndereco){
        this.numero = enderecoDTO.getNumero();
        this.rua = enderecoDTO.getRua();
        this.bairro = enderecoDTO.getBairro();
        this.cidade = enderecoDTO.getCidade();
        this.estado = enderecoDTO.getEstado();
        this.cep = enderecoDTO.getCep();
        this.enderecoCompleto = enderecoDTO.getEnderecoCompleto();
        this.pessoa = pessoaEndereco;
        
    }
      
 }

 

