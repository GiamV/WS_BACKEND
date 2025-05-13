package com.api.rest.ws.services;

import java.util.List;


import com.api.rest.ws.entities.User;

public interface IUserService {
	
	public List<User> findAll();
	
	//CREAR METODO PARA AGREGAR:
	public void saveUser(User user);
	
	//CREAR METODO PARA EDITAR:
	public User editarUser(Long id);
	
	
	
	
	

}
