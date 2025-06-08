package com.api.rest.ws.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.rest.ws.dto.EnunciadoDTO;
import com.api.rest.ws.repositories.EnunciadoRepository;

@RestController
@RequestMapping("/contenido")
public class EnunciadoProController {

    @Autowired
    private EnunciadoRepository repo;

    @GetMapping("/{idActividad}")
    public ResponseEntity<EnunciadoDTO> getContenido(@PathVariable Long idActividad) {
        EnunciadoDTO resultado = repo.obtenerEnunciadoCompleto(idActividad);
        return ResponseEntity.ok(resultado);
    }
}
