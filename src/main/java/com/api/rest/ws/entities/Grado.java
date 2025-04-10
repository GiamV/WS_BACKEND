package com.api.rest.ws.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Grado {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idGrado;
	
	private String grado;
	
	

}
