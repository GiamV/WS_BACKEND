package com.api.rest.ws.servicesR;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.rest.ws.entities.Opcion;

import com.api.rest.ws.repositories.IOpcionesRepository;
import com.api.rest.ws.repositories.IPreguntaRepository;

@Service
public class OpcionServiceR {
	
	@Autowired
	private IOpcionesRepository opcionesSQL;
	
	public List<Opcion> obtener_opciones(Long preguntaId) {
        return opcionesSQL.obtener_opciones(preguntaId);
    }

}
