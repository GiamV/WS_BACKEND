package com.api.rest.ws.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;

@Entity
@Table(name = "speaking")
public class Speaking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSpeaking;

    private String img;

    private String respuesta;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idActividad")
	Actividad actividad;


    public Long getIdSpeaking() {
		return idSpeaking;
	}

	public void setIdSpeaking(Long idSpeaking) {
		this.idSpeaking = idSpeaking;
	}

	public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

	public Actividad getActividad() {
		return actividad;
	}

	public void setActividad(Actividad actividad) {
		this.actividad = actividad;
	}
    
    

    


}