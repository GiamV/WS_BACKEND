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

import com.api.rest.ws.entities.Grado;
import com.api.rest.ws.services.IGradoService;


@RestController
@RequestMapping("/grado")
public class GradoController {
	
	@Autowired
	private IGradoService gradoService;
	
	// LISTAR 
		@GetMapping("/")
		public List<Grado> listar() {
			return gradoService.findAll();
		}
		// BUSCAR  POR ID
		@GetMapping("/{id}")
		public Grado grado(@PathVariable Long id) {
			return gradoService.findById(id);
		}
		
		//CREAR NUEVO GRADO
		@PostMapping("/nuevogrado")
		public Grado gradonew(@RequestBody Grado grado) {
			gradoService.saveGrado(grado);
			return gradoService.findById(grado.getIdGrado());
		}
		
		//ACTUALIZAR 
		@PutMapping("/{id}")
		public Grado actualizar(@RequestBody Grado grado,@PathVariable Long id) {
			Grado gradoActual=gradoService.findById(id);
			gradoActual.setGrado(grado.getGrado());
			
			gradoService.saveGrado(gradoActual);
			return gradoService .findById(id);
				
		}
		
		// ELIMINAR PERFIL
		@DeleteMapping("/{id}")
		public void delete(@PathVariable Long id) {
			gradoService.eliminarGrado(id);
		}
		
		
		
	

}
