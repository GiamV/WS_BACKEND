package com.api.rest.ws.services;

import java.util.List;
import com.api.rest.ws.entities.Enunciado;

public interface IEnunciadoService {
    List<Enunciado> findAll();
    Enunciado findById(Long id);
    void save(Enunciado pregunta);
    Enunciado editar(Long id);
    void eliminar(Long id);
}