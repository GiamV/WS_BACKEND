package com.api.rest.ws.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="respuesta")
public class Respuesta {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRespuesta;
	
	private String respuesta;
	private Boolean es_correcta;
	
	@ManyToOne
	@JoinColumn(name="idAlumno")
	Alumno alumno;
	
	@ManyToOne
	@JoinColumn(name="idActividad")
	Actividad actividad;

	public Long getIdRespuesta() {
		return idRespuesta;
	}

	public void setIdRespuesta(Long idRespuesta) {
		this.idRespuesta = idRespuesta;
	}

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	public Boolean getEs_correcta() {
		return es_correcta;
	}

	public void setEs_correcta(Boolean es_correcta) {
		this.es_correcta = es_correcta;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Actividad getActividad() {
		return actividad;
	}

	public void setActividad(Actividad actividad) {
		this.actividad = actividad;
	}
	
	

	
	

}
