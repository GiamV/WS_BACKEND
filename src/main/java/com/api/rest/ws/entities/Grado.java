package com.api.rest.ws.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="grado")
public class Grado {

	
	
	private static final long serialVersionUID=1L;	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idGrado;
	
	private String grado;

	public Long getIdGrado() {
		return idGrado;
	}

	public void setIdGrado(Long idGrado) {
		this.idGrado = idGrado;
	}

	public String getGrado() {
		return grado;
	}

	public void setGrado(String grado) {
		this.grado = grado;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
