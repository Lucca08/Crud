package com.example.crud.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Pessoa {
    
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "nome")
    @NotBlank
    private String nome;

    @Column(name = "data_nascimento", nullable = false)
    private LocalDate dataNascimento; 

    @Column(unique = true)
    @NotBlank
    private String cpf;

    @OneToOne
    @JoinColumn(name = "endereco_principal_id")
    private Endereco enderecoPrincipal;

    
    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private List<Endereco> enderecos;

    @Column
    private int idade;
}
