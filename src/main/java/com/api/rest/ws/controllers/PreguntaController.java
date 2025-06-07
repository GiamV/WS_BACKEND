package com.api.rest.ws.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.api.rest.ws.entities.Pregunta;
import com.api.rest.ws.services.IPreguntaService;

@RestController
@RequestMapping("/api/preguntas")
public class PreguntaController {

    @Autowired
    private IPreguntaService preguntaService;

    @GetMapping
    public List<Pregunta> listar() {
        return preguntaService.findAll();
    }

    @GetMapping("/{id}")
    public Pregunta obtener(@PathVariable Long id) {
        return preguntaService.findById(id);
    }

    @PostMapping
    public void guardar(@RequestBody Pregunta pregunta) {
        preguntaService.save(pregunta);
    }

    @PutMapping("/{id}")
    public Pregunta actualizar(@RequestBody Pregunta pregunta, @PathVariable Long id) {
        Pregunta actual = preguntaService.findById(id);
        
        if (actual != null) {
            actual.setEnunciado(pregunta.getEnunciado());
            actual.setTipoPregunta(pregunta.getTipoPregunta());
            actual.setRespuestaCorrecta(pregunta.getRespuestaCorrecta());
            actual.setOrden(pregunta.getOrden());
            actual.setActividad(pregunta.getActividad());

            preguntaService.save(actual);
        }

        return actual;
    }


    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        preguntaService.eliminar(id);
    }
}
