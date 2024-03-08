package com.clinica.backend.models;

import lombok.Data;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@Table(name = "paciente", schema = "clinica_medica")
public class Paciente {

    @Id
    @Column(name = "id_pessoa")
    private Integer idPessoa;

    @Column(name = "data_nascimento")
    private Date dataNascimento;

    private BigDecimal peso;

    private BigDecimal altura;

    @Column(length = 2, nullable = false)
    private String uf;

    @OneToOne
    @JoinColumn(name = "id_pessoa")
    private Pessoa pessoa;

}

