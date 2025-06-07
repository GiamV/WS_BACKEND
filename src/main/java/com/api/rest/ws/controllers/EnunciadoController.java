package com.api.rest.ws.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.api.rest.ws.entities.Enunciado;
import com.api.rest.ws.services.IEnunciadoService;
import com.api.rest.ws.servicesR.PreguntaServiceR;

@RestController
@RequestMapping("/pregunta")
public class EnunciadoController {

    @Autowired
    private IEnunciadoService preguntaService;
    
    @Autowired
    private PreguntaServiceR preguntaR;

    @GetMapping
    public List<Enunciado> listar() {
        return preguntaService.findAll();
    }

    @GetMapping("/{id}")
    public Enunciado obtener(@PathVariable Long id) {
        return preguntaService.findById(id);
    }

    @PostMapping
    public void guardar(@RequestBody Enunciado pregunta) {
        preguntaService.save(pregunta);
    }

    @PutMapping("/{id}")
    public Enunciado actualizar(@RequestBody Enunciado pregunta, @PathVariable Long id) {
        Enunciado actual = preguntaService.findById(id);
        
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
    
    @GetMapping("/por-actividad/{actividadId}")
    public List<Enunciado>obtenerPreguntas(@PathVariable Long actividadId) {
        
    	return preguntaR.obtener_preguntas_por_actividad(actividadId);

    }
    

}
