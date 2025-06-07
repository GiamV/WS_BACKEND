package com.api.rest.ws.services;

import java.util.List;
import com.api.rest.ws.entities.Opcion;

public interface IOpcionService {
    List<Opcion> findAll();
    Opcion findById(Long id);
    void save(Opcion opcion);
    Opcion editar(Long id);
    void eliminar(Long id);

    
}
