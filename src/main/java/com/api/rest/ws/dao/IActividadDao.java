package com.api.rest.ws.dao;

import org.springframework.data.repository.CrudRepository;

import com.api.rest.ws.entities.Actividad;

public interface IActividadDao extends CrudRepository<Actividad,Long> {

}
