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

}
