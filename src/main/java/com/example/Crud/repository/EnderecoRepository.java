package com.example.crud.repository;

import java.util.List; 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.crud.model.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

    List<Endereco> findByCep(String cep);

    List<Endereco> findByCidade(String cidade);

    List<Endereco> findByEstado(String estado);

    List<Endereco> findByBairro(String bairro);

    List<Endereco> findByRua(String rua);

    List<Endereco> findByNumero(String numero);

    List<Endereco> findByPessoaId(Long id);

    List<Endereco> findByPessoaIdAndCep(Long id, String cep);

    List<Endereco> findByPessoaIdAndCidade(Long id, String cidade);

    List<Endereco> findByPessoaIdAndEstado(Long id, String estado);
}
