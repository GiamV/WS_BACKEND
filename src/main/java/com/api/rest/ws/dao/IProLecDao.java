package com.api.rest.ws.dao;

import org.springframework.data.repository.CrudRepository;

import com.api.rest.ws.entities.Progreso_Leccion;

public interface IProLecDao extends CrudRepository<Progreso_Leccion,Long> {
	
}
