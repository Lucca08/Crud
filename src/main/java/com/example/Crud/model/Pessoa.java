package com.example.crud.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.example.crud.dto.CriaPessoaDTO;

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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
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

    @JoinTable(name = "tb_pessoa_endereco", joinColumns = @JoinColumn(name = "pessoa_id"), inverseJoinColumns = @JoinColumn(name = "endereco_id"))
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Endereco> enderecos;

    @Column
    private int idade;


    public Pessoa(CriaPessoaDTO pessoaDTO){
        this.nome = pessoaDTO.getNome();
        this.cpf = pessoaDTO.getCpf();
        this.dataNascimento = pessoaDTO.getDataNascimento();
        this.idade = pessoaDTO.getIdade();
        this.enderecos = new ArrayList<Endereco>();

    }

    public void adicionaEndereco(Endereco endereco){
        this.enderecos.add(endereco);
    }
}
