package com.api.rest.ws.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "opciones")
public class Opcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOpcion;

	@ManyToOne
	@JoinColumn(name="idPregunta")
	Pregunta pregunta;

    @Column(name = "texto_opcion")
    private String textoOpcion;

    @Column(name = "es_correcta")
    private Boolean esCorrecta;


	public Long getIdOpcion() {
		return idOpcion;
	}

	public void setIdOpcion(Long idOpcion) {
		this.idOpcion = idOpcion;
	}
	

	public Pregunta getPregunta() {
		return pregunta;
	}

	public void setPregunta(Pregunta pregunta) {
		this.pregunta = pregunta;
	}

	public String getTextoOpcion() {
		return textoOpcion;
	}

	public void setTextoOpcion(String textoOpcion) {
		this.textoOpcion = textoOpcion;
	}

	public Boolean getEsCorrecta() {
		return esCorrecta;
	}

	public void setEsCorrecta(Boolean esCorrecta) {
		this.esCorrecta = esCorrecta;
	}

    
}
