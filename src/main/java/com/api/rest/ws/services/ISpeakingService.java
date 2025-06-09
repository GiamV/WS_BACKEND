package com.api.rest.ws.services;

import java.util.List;
import com.api.rest.ws.entities.Speaking;

public interface ISpeakingService {
    List<Speaking> findAll();
    Speaking findById(Long id);
    void save(Speaking speaking);
    Speaking editar(Long id);
    void eliminar(Long id);
}
