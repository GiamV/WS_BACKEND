package com.api.rest.ws.controllers;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.api.rest.ws.entities.Opcion;
import com.api.rest.ws.services.IOpcionService;
import com.api.rest.ws.servicesR.OpcionServiceR;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/opcion")
public class OpcionController {

    @Autowired
    private IOpcionService opcionService;
    
    @Autowired
    private OpcionServiceR opcionServiceR;

    @GetMapping
    public List<Opcion> listar() {
        return opcionService.findAll();
    }

    @GetMapping("/{id}")
    public Opcion obtener(@PathVariable Long id) {
        return opcionService.findById(id);
    }

    @PostMapping
    public void guardar(@RequestBody Opcion opcion) {
        opcionService.save(opcion);
    }

    @PutMapping("/{id}")
    public Opcion actualizar(@RequestBody Opcion opcion, @PathVariable Long id) {
        Opcion actual = opcionService.findById(id);

        if (actual != null) {
            actual.setPregunta(opcion.getPregunta());
            actual.setTextoOpcion(opcion.getTextoOpcion());
            actual.setEsCorrecta(opcion.getEsCorrecta());

            opcionService.save(actual);
        }

        return actual;
    }

    
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        opcionService.eliminar(id);
    }
    
    @GetMapping("por-pregunta/{preguntaId}")
    public List<Opcion> listarOpciones(@PathVariable Long preguntaId) {
        return opcionServiceR.obtener_opciones(preguntaId);
    }
    
}
