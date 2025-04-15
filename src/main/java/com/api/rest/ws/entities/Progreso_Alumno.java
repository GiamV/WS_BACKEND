package com.api.rest.ws.entities;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="progreso")
public class Progreso_Alumno {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProgreso;
	
	private boolean completado;

	@Column(name="fecha_com")
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "yyyy-MM-dd")// Esto garantiza que se use este formato al serializar
	private Date fechacom;
	
	@ManyToOne
	@JoinColumn(name="idModulo")
	Modulo modulo;
	
	@ManyToOne
	@JoinColumn(name="idPerfil")
	Perfil perfil;

	public Long getIdProgreso() {
		return idProgreso;
	}

	public void setIdProgreso(Long idProgreso) {
		this.idProgreso = idProgreso;
	}

	public boolean isCompletado() {
		return completado;
	}

	public void setCompletado(boolean completado) {
		this.completado = completado;
	}

	public Date getFechacom() {
		return fechacom;
	}

	public void setFechacom(Date fechacom) {
		this.fechacom = fechacom;
	}

	public Modulo getModulo() {
		return modulo;
	}

	public void setModulo(Modulo modulo) {
		this.modulo = modulo;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}
	
	
	

}
