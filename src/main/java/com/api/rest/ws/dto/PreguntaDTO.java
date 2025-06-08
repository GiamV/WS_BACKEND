package com.api.rest.ws.dto;

import java.util.ArrayList;
import java.util.List;

public class PreguntaDTO {
    private Long id;
    private String texto;
    private List<OpcionDTO> opciones = new ArrayList<>();
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public List<OpcionDTO> getOpciones() {
		return opciones;
	}
	public void setOpciones(List<OpcionDTO> opciones) {
		this.opciones = opciones;
	}
    
    
    
}