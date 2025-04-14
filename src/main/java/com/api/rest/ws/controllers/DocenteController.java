package com.api.rest.ws.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.rest.ws.dto.UserDto;
import com.api.rest.ws.entities.Docente;
import com.api.rest.ws.entities.User;
import com.api.rest.ws.services.IDocenteService;
import com.api.rest.ws.services.UserService;





@RestController
@RequestMapping("/docente")
public class DocenteController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private IDocenteService docenteService;
	
	//LISTAR USUARIOS
		@GetMapping("/docentes")
		public List<Docente> listar(){
			return docenteService.findAll();
		}
		
		//BUSCAR USUARIO POR ID
		@GetMapping("/docente/{id}")
		public Docente docente (@PathVariable Long id) {
			return docenteService.findById(id);
		}
		
		//CREAR UN NUEVO USUARIO
		@PostMapping("/newdocente")
		public Docente newDocente(@RequestBody Docente docente) {
		    docenteService.saveDocente(docente);
		    
		    // Devolver el docente con el usuario asignado
		    return docenteService.findById(docente.getIdDocente());
		}
		
		//ACTUALIZAR USUARIO
		@PutMapping("/docenteact/{id}")
		public Docente actualizar(@RequestBody Docente docente,@PathVariable Long id) {
			Docente usuarioActual=docenteService.findById(id);
			usuarioActual.setFechanac(docente.getFechanac());
			usuarioActual.setSexo(docente.getSexo());
			usuarioActual.setDni(docente.getDni());
			docenteService.saveDocente(usuarioActual);
			return docenteService.findById(id);
		}
		
		//ELIMINAR USUARIO
		@DeleteMapping("/docentedelete/{id}")
		public void delete(@PathVariable Long id) {
			docenteService.eliminarDocente(id);
		}
	

}
