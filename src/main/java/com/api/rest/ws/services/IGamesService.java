package com.api.rest.ws.services;

import java.util.List;
import com.api.rest.ws.entities.Games;

public interface IGamesService {
    List<Games> findAll();
    Games findById(Long id);
    void save(Games game);
    Games editar(Long id);
    void eliminar(Long id);
}
