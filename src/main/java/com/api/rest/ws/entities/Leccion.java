package com.api.rest.ws.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="leccion")
public class Leccion {
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLeccion;
	
	private String titulo;
	private String descripcion;
	private String leccion;
	private String tipo;
	@ManyToOne
	@JoinColumn(name="idModulo")
	Modulo modulo;
	
	private String img;

	
	
	public Long getIdLeccion() {
		return idLeccion;
	}
	public void setIdLeccion(Long idLeccion) {
		this.idLeccion = idLeccion;
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
	
	public String getLeccion() {
		return leccion;
	}
	public void setLeccion(String leccion) {
		this.leccion = leccion;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
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
