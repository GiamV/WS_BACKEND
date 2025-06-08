package com.api.rest.ws.dto;

import java.util.ArrayList;
import java.util.List;

public class EnunciadoDTO {
    private Long id;
    private String enunciado;
    private String tipoPregunta;
    private List<PreguntaDTO> preguntas = new ArrayList<>();
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEnunciado() {
		return enunciado;
	}
	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}
	public String getTipoPregunta() {
		return tipoPregunta;
	}
	public void setTipoPregunta(String tipoPregunta) {
		this.tipoPregunta = tipoPregunta;
	}
	public List<PreguntaDTO> getPreguntas() {
		return preguntas;
	}
	public void setPreguntas(List<PreguntaDTO> preguntas) {
		this.preguntas = preguntas;
	}
    
    
    
}