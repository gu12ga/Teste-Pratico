package com.clinica.backend.models;
import lombok.Data;
import jakarta.persistence.*;

@Entity
@Data
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
}
