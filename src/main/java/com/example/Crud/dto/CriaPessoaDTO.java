package com.example.crud.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@AllArgsConstructor
@Getter
@Setter
public class CriaPessoaDTO{
  
  private String nome;
  private String cpf;
  private LocalDate dataNascimento;
  private CriaEnderecoDTO enderecoPrincipal;
  private int idade;

}