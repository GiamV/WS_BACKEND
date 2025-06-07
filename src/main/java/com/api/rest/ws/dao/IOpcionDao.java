package com.api.rest.ws.dao;

import org.springframework.data.repository.CrudRepository;
import com.api.rest.ws.entities.Opcion;

public interface IOpcionDao extends CrudRepository<Opcion, Long> {
}
