package com.api.rest.ws.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.rest.ws.entities.Perfil;
import com.api.rest.ws.repositories.IPerfilRepository;


@Service
public class PerfilServiceR {
	
	@Autowired
	IPerfilRepository perfilRepository;
	
	public Perfil findByU(Long ida) {
		return perfilRepository.findByUser (ida);
	} 
	
	
	

}
