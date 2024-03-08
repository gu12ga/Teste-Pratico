package com.clinica.backend.repositories;

import com.clinica.backend.models.Paciente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
public interface PacienteRepository extends JpaRepository<Paciente, Integer> {

    @Query("SELECT p FROM Paciente p.peso WHERE p.peso = :nome")
    List<Paciente> findBySenha(@Param("peso") String peso);
}
