package com.api.rest.ws.dao;

import org.springframework.data.repository.CrudRepository;
import com.api.rest.ws.entities.Games;

public interface IGamesDao extends CrudRepository<Games, Long> {
}
