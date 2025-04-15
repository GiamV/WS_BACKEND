package com.api.rest.ws.services;

import java.util.List;

import com.api.rest.ws.entities.Perfil;



public interface IPerfilService {
	public List<Perfil> findAll();
	
	//CREAR METODO PARA AGREGAR:
	public void savePerfil(Perfil perfil);
	
	//CREAR METODO PARA EDITAR:
	public Perfil editarPerfil(Long id);
	
	//CREAR METODO PARA ELIMINAR:
	public void eliminarPerfil(Long id);
	
	public Perfil findById(Long id);

}
