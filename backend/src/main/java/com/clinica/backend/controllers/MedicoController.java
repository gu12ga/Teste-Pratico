package com.clinica.backend.controllers;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @PreAuthorize("hasRole('MEDICO')")
    @PostMapping("/criarPaciente")
    public ResponseEntity<String> criarPaciente() {
        // Implemente a lógica de criação de pacientes
        return ResponseEntity.ok("Paciente criado com sucesso por um médico.");
    }
}