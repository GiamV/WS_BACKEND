package com.api.rest.ws.services;

import java.util.List;

import com.api.rest.ws.entities.Grado;

public interface IGradoService {
	
	public List<Grado> findAll();
	
	//CREAR METODO PARA AGREGAR:
	public void saveGrado(Grado grado);
	
	//CREAR METODO PARA EDITAR:
	public Grado editarGrado(Long id);
	
	//CREAR METODO PARA ELIMINAR:
	public void eliminarGrado(Long id);
	
	public Grado findById(Long id);


}
