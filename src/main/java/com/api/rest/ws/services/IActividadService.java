package com.api.rest.ws.services;

import java.util.List;

import com.api.rest.ws.entities.Actividad;


public interface IActividadService {

public List<Actividad> findAll();
	
	//CREAR METODO PARA AGREGAR:
	public void saveActividad(Actividad actividad);
	
	//CREAR METODO PARA EDITAR:
	public Actividad editarActividad(Long id);
	
	//CREAR METODO PARA ELIMINAR:
	public void eliminarActividad(Long id);
	
	public Actividad findById(Long id);
}
