package com.example.Crud.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.Crud.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    
    List<Pessoa> findByNome(String nome);

    List<Pessoa> findByCpf(String cpf);

    List<Pessoa> findByEmail(String email);

    List<Pessoa> findByTelefone(String telefone);

    List<Pessoa> findByDataNascimento(String dataNascimento);


}

