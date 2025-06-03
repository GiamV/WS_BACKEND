package com.api.rest.ws.servicesR;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.rest.ws.repositories.IProLecRepository;

@Service
public class ProLecServiceR {
	
	@Autowired
	private IProLecRepository prolecSQL;
	
	public void marcar_completado(Long leccion,Long perfil) {
		prolecSQL.marcar_completado(leccion,perfil);
	}

}
