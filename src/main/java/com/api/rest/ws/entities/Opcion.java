package com.api.rest.ws.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;

@Entity
@Table(name = "opciones")
public class Opcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOpcion;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_Preguntas")
	Preguntas preguntaw;

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
	


	

	public Preguntas getPreguntaw() {
		return preguntaw;
	}

	public void setPreguntaw(Preguntas preguntaw) {
		this.preguntaw = preguntaw;
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
