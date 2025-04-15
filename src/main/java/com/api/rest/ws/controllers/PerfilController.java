package com.api.rest.ws.controllers;

import java.util.List;
import java.util.Optional;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.rest.ws.dto.PerfilDto;
import com.api.rest.ws.dto.UserDto;
import com.api.rest.ws.entities.Perfil;
import com.api.rest.ws.entities.Rol;
import com.api.rest.ws.entities.User;
import com.api.rest.ws.services.IPerfilService;
import com.api.rest.ws.services.IRolService;
import com.api.rest.ws.services.PerfilServiceR;
import com.api.rest.ws.services.UserService;



@RestController
@RequestMapping("/perfil")
public class PerfilController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PerfilServiceR perfilSR;

	@Autowired
	private IPerfilService perfilService;
	@Autowired
	private IRolService rolService;

	// LISTAR PERFILES
	@GetMapping("/")
	public List<Perfil> listar() {
		return perfilService.findAll();
	}

	// BUSCAR PERFIL POR ID
	@GetMapping("/{id}")
	public Perfil perfil(@PathVariable Long id) {
		return perfilService.findById(id);
	}
	
	@GetMapping("/busqueda/{id}")
	public PerfilDto perfilbyU(@PathVariable Long id) {
		Perfil perfilactual=perfilSR.findByU(id);
		PerfilDto Dto = new PerfilDto();
		Dto.setIdPerfil(perfilactual.getIdPerfil());
		Dto.setDni(perfilactual.getDni());
		Dto.setNombre(perfilactual.getNombre());
		Dto.setApellido(perfilactual.getApellido());
		Dto.setUsuarioId(perfilactual.getUsuario().getId()); // Solo el ID
		Dto.setRolId(perfilactual.getRol().getIdRol());   
		
		Dto.setFotoperfil(perfilactual.getFotoperfil());
		Dto.setSexo(perfilactual.getSexo());
		Dto.setFechanac(perfilactual.getFechanac()); // Solo el ID
		Dto.setGradoId(perfilactual.getGrado().getIdGrado());   
		
		
		
		return Dto;
	}

	@Transactional
	// CREAR UN NUEVO PERFIL
	@PostMapping("/nuevo")
	public Perfil nuevoPerfil(@RequestBody Perfil perfil) {
		
		Rol rol = rolService.findById(Long.valueOf(perfil.getRol().getIdRol() ));
		User user = userService.findById(Long.valueOf(perfil.getUsuario().getId()));
		
		perfil.setRol(rol);
		perfil.setUsuario(user);
		
		
		perfilService.savePerfil(perfil);

		// Devolver el perfil con el usuario asignado
		return perfilService.findById(perfil.getIdPerfil());
	}

	// ACTUALIZAR PERFIL
	@PutMapping("/{id}")
	public Perfil actualizar(@RequestBody Perfil perfil, @PathVariable Long id) {
		Perfil perfilActual = perfilService.findById(id);
		perfilActual.setNombre(perfil.getNombre());
		perfilActual.setApellido(perfil.getApellido());
		perfilActual.setFechanac(perfil.getFechanac());
		perfilActual.setSexo(perfil.getSexo());
		perfilActual.setDni(perfil.getDni());
		perfilActual.setFotoperfil(perfil.getFotoperfil());
		perfilService.savePerfil(perfilActual);
		return perfilService.findById(id);
	}

	// ELIMINAR PERFIL
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		perfilService.eliminarPerfil(id);
	}
	
	
	
	
	
	
	

}
