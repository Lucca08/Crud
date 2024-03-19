package com.example.crud.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

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

    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;
      
 }

 

