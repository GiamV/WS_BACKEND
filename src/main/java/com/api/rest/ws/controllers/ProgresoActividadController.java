package com.api.rest.ws.controllers;

import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.api.rest.ws.entities.Opcion;
import com.api.rest.ws.entities.Progreso_Actividad;
import com.api.rest.ws.services.IProgresoActividadService;
import com.api.rest.ws.servicesR.OpcionServiceR;
import com.api.rest.ws.servicesR.ProActServiceR;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/progreso-actividad")
public class ProgresoActividadController {

    @Autowired
    private IProgresoActividadService progresoService;
    
    @Autowired
    private ProActServiceR proactServiceR;

    @GetMapping
    public List<Progreso_Actividad> listar() {
        return progresoService.findAll();
    }

    @GetMapping("/{id}")
    public Progreso_Actividad obtener(@PathVariable Long id) {
        return progresoService.findById(id);
    }

    @PostMapping
    public void guardar(@RequestBody Progreso_Actividad progreso) {
        progresoService.save(progreso);
    }

    @PutMapping("/{id}")
    public Progreso_Actividad actualizar(@RequestBody Progreso_Actividad progreso, @PathVariable Long id) {
    	Progreso_Actividad actual = progresoService.findById(id);
        if (actual != null) {
            actual.setPerfil(progreso.getPerfil());
            actual.setActividad(progreso.getActividad());
            actual.setCompletado(progreso.getCompletado());
            progresoService.save(actual);
        }
        return actual;
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        progresoService.eliminar(id);
    }
    
    @GetMapping("por-perfil/{p_id_perfil}")
    public List<Progreso_Actividad> listaractividadesp(@PathVariable Long p_id_perfil) {
        return proactServiceR.pro_actividad(p_id_perfil);
    }
    
    @PutMapping("pro-act-est/{id}")
    public Progreso_Actividad actualizarestado(@PathVariable Long id) {
        Progreso_Actividad actual = progresoService.findById(id);
        if (actual != null) {
            actual.setCompletado(true);
            progresoService.save(actual);
        }
        return actual;
    }
}