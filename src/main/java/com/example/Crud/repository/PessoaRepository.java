package com.example.crud.repository;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.crud.model.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    
    List<Pessoa> findByNome(String nome);

    List<Pessoa> findByCpf(String cpf);

    List<Pessoa> findByDataNascimento(LocalDate dataNascimento);

    boolean existsByCpf(String cpf);


}

