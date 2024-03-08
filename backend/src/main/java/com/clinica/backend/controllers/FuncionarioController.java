package com.clinica.backend.controllers;

import com.clinica.backend.models.Funcionario;
import com.clinica.backend.models.Pessoa;
import com.clinica.backend.repositories.FuncionarioRepository;
import com.clinica.backend.repositories.PessoaRepository;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    // Endpoint para adicionar um novo funcionário
    @PostMapping
    public Funcionario addFuncionario(@RequestBody Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    private static class Usuario{

        public String senha;
        public String cpf;

    }
    // Classe para representar a resposta em formato JSON
    private static class RespostaJson {
        private int status;
        private String mensagem;

        public RespostaJson(int status, String mensagem) {
            this.status = status;
            this.mensagem = mensagem;
        }

        public int getStatus() {
            return status;
        }

        public String getMensagem() {
            return mensagem;
        }
    }
    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody Usuario usuario) {
        
        Pessoa pessoa = pessoaRepository.findByCpf(usuario.cpf).get(0);

        if(pessoa != null && !pessoa.getFlagTipo().equals("P")){
            Optional<Funcionario> func = funcionarioRepository.findById(pessoa.getId());

            if(func.get().getSenha().equals(usuario.senha)){

                if(pessoa.getFlagTipo().equals("M")){
                    return ResponseEntity.ok().body(new RespostaJson(HttpStatus.OK.value(), "medico")); 
                } else{

                    return ResponseEntity.ok().body(new RespostaJson(HttpStatus.OK.value(), "enfermeiro")); 

                }
            }
        }

        return ResponseEntity.status(400).body("");
    }

    @PutMapping("/{id}")
    public Funcionario updateFuncionario(@PathVariable Integer id, @RequestBody Funcionario funcionarioDetails) {
        Funcionario funcionario = funcionarioRepository.findById(id).orElse(null);

        if (funcionario != null) {
            funcionario.setSenha(funcionarioDetails.getSenha());
            return funcionarioRepository.save(funcionario);
        }

        return null;
    }
    
    @DeleteMapping("/{id}")
    public void deleteFuncionario(@PathVariable Integer id) {
        funcionarioRepository.deleteById(id);
    }
}

