package com.api.rest.ws.dao;

import org.springframework.data.repository.CrudRepository;
import com.api.rest.ws.entities.Preguntas;

public interface IPreguntasDao extends CrudRepository<Preguntas, Long> {
}