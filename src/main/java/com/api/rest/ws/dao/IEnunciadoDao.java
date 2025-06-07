package com.api.rest.ws.dao;

import org.springframework.data.repository.CrudRepository;
import com.api.rest.ws.entities.Enunciado;

public interface IEnunciadoDao extends CrudRepository<Enunciado, Long> {
}