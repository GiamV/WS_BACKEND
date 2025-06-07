package com.api.rest.ws.servicesR;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.rest.ws.entities.Pregunta;
import com.api.rest.ws.repositories.IPreguntaRepository;


@Service
public class PreguntaServiceR {
	
	@Autowired
	private IPreguntaRepository preguntaSQL;
	
    public List<Pregunta> obtener_preguntas_por_actividad(Long actividadId) {
        return preguntaSQL.obtener_preguntas(actividadId);
    }
	

}
