package com.clinica.backend.models;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "pessoa", schema = "clinica_medica")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false, length = 11)
    private String cpf;

    @Column(nullable = false, length = 255)
    private String nome;

    @Column(nullable = false, length = 1)
    private String flagTipo;
}

