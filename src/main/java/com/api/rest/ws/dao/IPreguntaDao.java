package com.api.rest.ws.dao;

import org.springframework.data.repository.CrudRepository;
import com.api.rest.ws.entities.Pregunta;

public interface IPreguntaDao extends CrudRepository<Pregunta, Long> {
}