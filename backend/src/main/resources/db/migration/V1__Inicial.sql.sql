CREATE SCHEMA IF NOT EXISTS clinica_medica;

CREATE TABLE IF NOT EXISTS clinica_medica.pessoa (
    id INT PRIMARY KEY,
    cpf VARCHAR(11) UNIQUE NOT NULL,
    nome VARCHAR(255) NOT NULL,
    flag_tipo VARCHAR(1) NOT NULL
);

CREATE TABLE IF NOT EXISTS clinica_medica.paciente (
    id_pessoa INT PRIMARY KEY,
    data_nascimento DATE,
    peso DECIMAL(5,2),
    altura DECIMAL(3,2),
    uf VARCHAR(2) NOT NULL,
    FOREIGN KEY (id_pessoa) REFERENCES clinica_medica.pessoa(id)
);

CREATE TABLE IF NOT EXISTS clinica_medica.funcionario (
    id_pessoa INT PRIMARY KEY,
    senha VARCHAR(255) NOT NULL,
    FOREIGN KEY (id_pessoa) REFERENCES clinica_medica.pessoa(id)
);

INSERT INTO clinica_medica.pessoa (id, cpf, nome, flag_tipo)
VALUES (1, '12345678901', 'Dr. João', 'M');

INSERT INTO clinica_medica.funcionario (id_pessoa, senha)
VALUES (1, '12345');