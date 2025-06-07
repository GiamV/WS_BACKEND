package com.api.rest.ws.services;

import java.util.List;
import com.api.rest.ws.entities.Preguntas;

public interface IPreguntasService {
    List<Preguntas> findAll();
    Preguntas findById(Long id);
    void save(Preguntas pregunta);
    Preguntas editar(Long id);
    void eliminar(Long id);
}