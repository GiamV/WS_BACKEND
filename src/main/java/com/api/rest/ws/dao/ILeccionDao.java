package com.api.rest.ws.dao;

import org.springframework.data.repository.CrudRepository;

import com.api.rest.ws.entities.Leccion;

public interface ILeccionDao extends CrudRepository<Leccion,Long> {

}