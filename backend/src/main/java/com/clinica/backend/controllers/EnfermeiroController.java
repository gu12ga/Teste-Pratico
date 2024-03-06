package com.clinica.backend.controllers;

@RestController
@RequestMapping("/enfermeiros")
public class EnfermeiroController {

    @PreAuthorize("hasRole('ENFERMEIRO')")
    @PostMapping("/criarPaciente")
    public ResponseEntity<String> criarPaciente() {
        // Implemente a lógica de criação de pacientes
        return ResponseEntity.ok("Paciente criado com sucesso por um enfermeiro.");
    }
}
