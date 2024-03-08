package com.clinica.backend.repositories;

import com.clinica.backend.models.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {
    @Query("SELECT f FROM Funcionario f WHERE f.senha = :senha")
    List<Funcionario> findBySenha(@Param("senha") String senha);
}
