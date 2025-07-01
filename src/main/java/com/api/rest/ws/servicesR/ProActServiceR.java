package com.api.rest.ws.servicesR;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.rest.ws.entities.Opcion;
import com.api.rest.ws.entities.Progreso_Actividad;
import com.api.rest.ws.repositories.IOpcionesRepository;
import com.api.rest.ws.repositories.IProActRepository;

@Service
public class ProActServiceR {
	
	@Autowired
	private IProActRepository proactSQL;
	
	public List<Progreso_Actividad> pro_actividad(Long perfilId) {
        return proactSQL.pro_actividad(perfilId);
    }
	

}
