package com.clinica.backend.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/estados")
public class EstadosController {
    
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/siglas")
    public List<String> getSiglasEstados() {
        String apiUrl = "https://servicodados.ibge.gov.br/api/v1/localidades/estados";

        ResponseEntity<List<EstadoDTO>> response = restTemplate.exchange(
                apiUrl,
                org.springframework.http.HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<EstadoDTO>>() {});

        List<EstadoDTO> estados = response.getBody();

        if (estados != null) {
            return estados.stream()
                    .map(EstadoDTO::getSigla)
                    .collect(Collectors.toList());
        }

        return null;
    }

    private static class EstadoDTO {
        
        private String sigla;


    
        public String getSigla(){
            return sigla;
        }
    }
}
