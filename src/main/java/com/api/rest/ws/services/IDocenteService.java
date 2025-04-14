package com.api.rest.ws.services;

import java.util.List;

import com.api.rest.ws.entities.Docente;



public interface IDocenteService {
	public List<Docente> findAll();
	
	//CREAR METODO PARA AGREGAR:
	public void saveDocente(Docente producto);
	
	//CREAR METODO PARA EDITAR:
	public Docente editarDocente(Long id);
	
	//CREAR METODO PARA ELIMINAR:
	public void eliminarDocente(Long id);
	
	public Docente findById(Long id);

}
