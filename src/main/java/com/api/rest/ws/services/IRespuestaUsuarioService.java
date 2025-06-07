package com.api.rest.ws.services;

import java.util.List;
import com.api.rest.ws.entities.RespuestaUsuario;

public interface IRespuestaUsuarioService {
    List<RespuestaUsuario> findAll();
    RespuestaUsuario findById(Long id);
    void save(RespuestaUsuario respuesta);
    RespuestaUsuario editar(Long id);
    void eliminar(Long id);
}
