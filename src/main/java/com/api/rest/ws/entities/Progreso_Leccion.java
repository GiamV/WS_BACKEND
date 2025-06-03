package com.api.rest.ws.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="progreso_leccion")
public class Progreso_Leccion {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProgreso_Lec;
	
	@ManyToOne
	@JoinColumn(name="idLeccion")
	Leccion leccion;
	@ManyToOne
	@JoinColumn(name="idPerfil")
	Perfil perfil;
	
	private boolean completado;
	
	
	public Long getIdProgreso_Lec() {
		return idProgreso_Lec;
	}
	public void setIdProgreso_Lec(Long idProgreso_Lec) {
		this.idProgreso_Lec = idProgreso_Lec;
	}
	public Leccion getLeccion() {
		return leccion;
	}
	public void setLeccion(Leccion leccion) {
		this.leccion = leccion;
	}
	public Perfil getPerfil() {
		return perfil;
	}
	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}
	public boolean isCompletado() {
		return completado;
	}
	public void setCompletado(boolean completado) {
		this.completado = completado;
	}
	
	
	
	
	
	

}
