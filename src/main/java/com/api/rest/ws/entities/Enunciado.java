package com.api.rest.ws.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;

@Entity
@Table(name = "enunciado")
public class Enunciado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEnunciado;

    
    @Lob // 👈 Esto es CLAVE para usar TEXT o LONGTEXT en la base de datos
    @Column(columnDefinition = "TEXT") // o "LONGTEXT" si lo necesitas
    private String enunciado;

    @Column(name = "tipo_pregunta")
    private String tipoPregunta;

    @Column(name = "respuesta_correcta")
    private String respuestaCorrecta;

    private int orden;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idActividad")
	Actividad actividad;

    // Getters y Setters


    public String getEnunciado() {
        return enunciado;
    }

	public Long getIdEnunciado() {
		return idEnunciado;
	}



	public void setIdEnunciado(Long idEnunciado) {
		this.idEnunciado = idEnunciado;
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

    public String getRespuestaCorrecta() {
        return respuestaCorrecta;
    }

    public void setRespuestaCorrecta(String respuestaCorrecta) {
        this.respuestaCorrecta = respuestaCorrecta;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

	public Actividad getActividad() {
		return actividad;
	}

	public void setActividad(Actividad actividad) {
		this.actividad = actividad;
	}
    


}