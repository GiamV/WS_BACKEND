package com.api.rest.ws.services;

import java.util.List;


import com.api.rest.ws.entities.Rol;

public interface IRolService {
	
	
	public List<Rol> findAll();
	
	//CREAR METODO PARA AGREGAR:
	public void saveRol(Rol rol);
	
	//CREAR METODO PARA EDITAR:
	public Rol editarRol(Long id);
	
	//CREAR METODO PARA ELIMINAR:
	public void eliminarRol(Long id);
	
	public Rol findById(Long id);

}
