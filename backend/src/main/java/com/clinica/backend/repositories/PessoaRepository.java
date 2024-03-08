package com.clinica.backend.repositories;

import com.clinica.backend.models.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {
    
    @Query("SELECT p FROM Pessoa p WHERE p.nome = :nome")
    List<Pessoa> findByNomePessoa(@Param("nome") String nome);

    List<Pessoa> findByCpf(String cpf);

    List<Pessoa> findByNome(String nome);
}
