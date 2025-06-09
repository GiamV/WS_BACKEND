package com.api.rest.ws.services;

import java.util.List;

import com.api.rest.ws.entities.Progreso_Actividad;


public interface IProgresoActividadService {
    List<Progreso_Actividad> findAll();
    Progreso_Actividad findById(Long id);
    void save(Progreso_Actividad progreso);
    Progreso_Actividad editar(Long id);
    void eliminar(Long id);
}
