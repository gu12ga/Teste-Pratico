package com.clinica.backend.controllers;
import com.clinica.backend.models.Paciente;
import com.clinica.backend.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository pacienteRepository;

    @GetMapping
    public List<Paciente> getAllPacientes() {
        return pacienteRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> getPacienteById(@PathVariable Integer id) {
        Optional<Paciente> pacienteOptional = pacienteRepository.findById(id);
        return pacienteOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Paciente createPaciente(@RequestBody Paciente paciente) {
        return pacienteRepository.save(paciente);
    }


    @PutMapping("/{id}")
    public Paciente updatepaciente(@PathVariable Integer id, @RequestBody Paciente pacienteDetails) {
        Paciente paciente = pacienteRepository.findById(id).orElse(null);

        if (paciente != null) {
            paciente.setPeso(pacienteDetails.getPeso());

            return pacienteRepository.save(paciente);
        }

        return null;
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePaciente(@PathVariable Integer id) {
        if (!pacienteRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        pacienteRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
