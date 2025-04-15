package com.api.rest.ws.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class PerfilDto {
    private Long idPerfil;
    private String nombre;
    private String apellido;
    private String dni;
	private String fotoperfil;
	private String sexo;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date fechanac;
    private Long usuarioId;  // Solo el ID del usuario
    private Long rolId;
    private Long gradoId;   // Solo el ID del rol
	public Long getIdPerfil() {
		return idPerfil;
	}
	public void setIdPerfil(Long idPerfil) {
		this.idPerfil = idPerfil;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getFotoperfil() {
		return fotoperfil;
	}
	public void setFotoperfil(String fotoperfil) {
		this.fotoperfil = fotoperfil;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public Date getFechanac() {
		return fechanac;
	}
	public void setFechanac(Date fechanac) {
		this.fechanac = fechanac;
	}
	public Long getUsuarioId() {
		return usuarioId;
	}
	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}
	public Long getRolId() {
		return rolId;
	}
	public void setRolId(Long rolId) {
		this.rolId = rolId;
	}
	public Long getGradoId() {
		return gradoId;
	}
	public void setGradoId(Long gradoId) {
		this.gradoId = gradoId;
	}

    // Getters y Setters
    
}
