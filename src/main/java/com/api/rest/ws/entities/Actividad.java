package com.api.rest.ws.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="actividad")
public class Actividad {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idActividad;
	
	private String titulo;
	private String descripcion;
	private int tipo;
	@ManyToOne
	@JoinColumn(name="idModulo")
	Modulo modulo;
	
	private String img;
	
	
	public Long getIdActividad() {
		return idActividad;
	}
	public void setIdActividad(Long idActividad) {
		this.idActividad = idActividad;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	public Modulo getModulo() {
		return modulo;
	}
	public void setModulo(Modulo modulo) {
		this.modulo = modulo;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	
	
	
	
	
	

}
