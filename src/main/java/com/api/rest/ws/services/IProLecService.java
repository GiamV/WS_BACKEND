package com.api.rest.ws.services;

import java.util.List;


import com.api.rest.ws.entities.Progreso_Leccion;

public interface IProLecService {
	
public List<Progreso_Leccion> findAll();
	
	//CREAR METODO PARA AGREGAR:
	public void saveProLec(Progreso_Leccion progreso_Leccion);
	
	//CREAR METODO PARA EDITAR:
	public Progreso_Leccion editarProLec(Long id);
	
	//CREAR METODO PARA ELIMINAR:
	public void eliminarProLec(Long id);
	
	public Progreso_Leccion findById(Long id);
	

}
