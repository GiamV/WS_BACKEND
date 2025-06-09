package com.api.rest.ws.servicesR;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.rest.ws.entities.Speaking;
import com.api.rest.ws.repositories.IPreguntaRepository;
import com.api.rest.ws.repositories.ISpeakingRepository;

@Service
public class SpeakingServiceR {
	
	@Autowired
	private ISpeakingRepository speakingSQL;
	
	
	public List<Speaking> obtener_speaking_por_actividad(Long actividadId) {
        return speakingSQL.obtener_speaking(actividadId);
    }

}
