package com.api.rest.ws.services;

import java.util.List;
import com.api.rest.ws.entities.Pregunta;

public interface IPreguntaService {
    List<Pregunta> findAll();
    Pregunta findById(Long id);
    void save(Pregunta pregunta);
    Pregunta editar(Long id);
    void eliminar(Long id);
}