package com.api.rest.ws.dao;

import org.springframework.data.repository.CrudRepository;
import com.api.rest.ws.entities.RespuestaUsuario;

public interface IRespuestaUsuarioDao extends CrudRepository<RespuestaUsuario, Long> {
}
