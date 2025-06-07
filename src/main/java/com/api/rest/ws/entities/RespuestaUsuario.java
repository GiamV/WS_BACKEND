package com.api.rest.ws.entities;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "respuesta_usuario")
public class RespuestaUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@ManyToOne
	@JoinColumn(name="idPerfil")
	Perfil perfil;
	
	@ManyToOne
	@JoinColumn(name="idEnunciado")
	Enunciado pregunta;

    @Column(name = "respuesta_texto")
    private String respuestaTexto;

    @Column(name = "respuesta_audio_url")
    private String respuestaAudioUrl;

    @Column(name = "es_correcta")
    private Boolean esCorrecta;

    @Column(name = "fecha_respuesta")
    private Timestamp fechaRespuesta;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public Enunciado getPregunta() {
		return pregunta;
	}

	public void setPregunta(Enunciado pregunta) {
		this.pregunta = pregunta;
	}

	public String getRespuestaTexto() {
		return respuestaTexto;
	}

	public void setRespuestaTexto(String respuestaTexto) {
		this.respuestaTexto = respuestaTexto;
	}

	public String getRespuestaAudioUrl() {
		return respuestaAudioUrl;
	}

	public void setRespuestaAudioUrl(String respuestaAudioUrl) {
		this.respuestaAudioUrl = respuestaAudioUrl;
	}

	public Boolean getEsCorrecta() {
		return esCorrecta;
	}

	public void setEsCorrecta(Boolean esCorrecta) {
		this.esCorrecta = esCorrecta;
	}

	public Timestamp getFechaRespuesta() {
		return fechaRespuesta;
	}

	public void setFechaRespuesta(Timestamp fechaRespuesta) {
		this.fechaRespuesta = fechaRespuesta;
	}

    // Getters y Setters
    
    
}
