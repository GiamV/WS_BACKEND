package com.api.rest.ws.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.api.rest.ws.entities.Preguntas;
import com.api.rest.ws.services.IPreguntasService;

@RestController
@RequestMapping("/api/preguntas")
public class PreguntasController {

    @Autowired
    private IPreguntasService preguntasService;

    @GetMapping
    public List<Preguntas> listar() {
        return preguntasService.findAll();
    }
    

    @GetMapping("/{id}")
    public Preguntas obtener(@PathVariable Long id) {
        return preguntasService.findById(id);
    }

    @PostMapping
    public void guardar(@RequestBody Preguntas pregunta) {
        preguntasService.save(pregunta);
    }

    @PutMapping("/{id}")
    public Preguntas actualizar(@RequestBody Preguntas pregunta, @PathVariable Long id) {
        Preguntas actual = preguntasService.findById(id);

        if (actual != null) {
            actual.setPregunta(pregunta.getPregunta());
            actual.setEnunciado(pregunta.getEnunciado());
            preguntasService.save(actual);
        }

        return actual;
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        preguntasService.eliminar(id);
    }
}
