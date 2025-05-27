package com.api.rest.ws.services;

import java.util.List;

import com.api.rest.ws.entities.Modulo;

public interface IModuloService {
public List<Modulo> findAll();
	
	//CREAR METODO PARA AGREGAR:
	public void saveModulo(Modulo modulo);
	
	//CREAR METODO PARA EDITAR:
	public Modulo editarModulo(Long id);
	
	//CREAR METODO PARA ELIMINAR:
	public void eliminarModulo(Long id);
	
	public Modulo findById(Long id);
}
