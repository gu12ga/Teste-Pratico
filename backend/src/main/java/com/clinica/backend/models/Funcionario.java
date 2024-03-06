package com.clinica.backend.models;

import javax.persistence.*;

@Entity
@Table(name = "funcionario", schema = "clinica_medica")
public class Funcionario {

    @Id
    @Column(name = "id_pessoa")
    private Integer idPessoa;

    @Column(nullable = false, length = 255)
    private String senha;

    @OneToOne
    @JoinColumn(name = "id_pessoa")
    private Pessoa pessoa;

    // getters and setters
}
