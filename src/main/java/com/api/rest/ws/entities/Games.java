package com.api.rest.ws.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "games")
public class Games {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idGames;

    private String url;
    private String titulo;
    private String descripcion;
    private String img;

    // Getters y Setters

    public Long getIdGames() {
		return idGames;
	}

	public void setIdGames(Long idGames) {
		this.idGames = idGames;
	}

    public String getUrl() {
        return url;
    }



	public void setUrl(String url) {
        this.url = url;
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}