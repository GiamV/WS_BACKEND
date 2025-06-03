package com.api.rest.ws.services;

import java.util.List;


import com.api.rest.ws.entities.Leccion;

public interface ILeccionService {
	
public List<Leccion> findAll();
	
	//CREAR METODO PARA AGREGAR:
	public void saveLeccion(Leccion leccion);
	
	//CREAR METODO PARA EDITAR:
	public Leccion editarLeccion(Long id);
	
	//CREAR METODO PARA ELIMINAR:
	public void eliminarLeccion(Long id);
	
	public Leccion findById(Long id);

}
