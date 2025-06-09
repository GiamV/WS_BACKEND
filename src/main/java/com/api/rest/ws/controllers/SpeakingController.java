package com.api.rest.ws.controllers;

import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.api.rest.ws.entities.Enunciado;
import com.api.rest.ws.entities.Speaking;
import com.api.rest.ws.services.ISpeakingService;
import com.api.rest.ws.servicesR.SpeakingServiceR;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/speaking")
public class SpeakingController {

    @Autowired
    private ISpeakingService speakingService;
    @Autowired
    private SpeakingServiceR speakingServiceR;
    

    @GetMapping
    public List<Speaking> listar() {
        return speakingService.findAll();
    }

    @GetMapping("/{id}")
    public Speaking obtener(@PathVariable Long id) {
        return speakingService.findById(id);
    }

    @PostMapping
    public void guardar(@RequestBody Speaking speaking) {
        speakingService.save(speaking);
    }

    @PutMapping("/{id}")
    public Speaking actualizar(@RequestBody Speaking speaking, @PathVariable Long id) {
        Speaking actual = speakingService.findById(id);
        if (actual != null) {
            actual.setImg(speaking.getImg());
            actual.setRespuesta(speaking.getRespuesta());
            actual.setActividad(speaking.getActividad());
            speakingService.save(actual);
        }
        return actual;
    }
    
    @GetMapping("/por-actividad/{actividadId}")
    public List<Speaking>obtenerSpeaking(@PathVariable Long actividadId) {
        
    	return speakingServiceR.obtener_speaking_por_actividad(actividadId);

    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        speakingService.eliminar(id);
    }
}
