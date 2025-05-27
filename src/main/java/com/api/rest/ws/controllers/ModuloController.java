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
import com.api.rest.ws.entities.Modulo;

import com.api.rest.ws.services.IGradoService;
import com.api.rest.ws.services.IModuloService;


@RestController
@RequestMapping("/modulo")
public class ModuloController {
	@Autowired
	private IModuloService moduloService;
	
	@Autowired
	private IGradoService gradoService;
	
	// LISTAR 
		@GetMapping("/")
		public List<Modulo> listar() {
			return moduloService.findAll();
		}
		
		// BUSCAR POR ID
		@GetMapping("/{id}")
		public Modulo modulo(@PathVariable Long id) {
			return moduloService.findById(id);
		}
		
		//CREAR NUEVO 
		@PostMapping("/nuevomodulo")
		public Modulo modulonew(@RequestBody Modulo modulo) {
			
			Grado grado = gradoService.findById(Long.valueOf(modulo.getGrado().getIdGrado() ));
			modulo.setGrado(grado);
			moduloService.saveModulo(modulo);
			return moduloService.findById(modulo.getIdModulo());
		}

		//ACTUALIZAR 
		@PutMapping("/{id}")
		public Modulo actualizar(@RequestBody Modulo modulo,@PathVariable Long id) {
			Modulo moduloActual=moduloService.findById(id);
			moduloActual.setModulo(modulo.getModulo());
			moduloActual.setDescripcion(modulo.getDescripcion());
			moduloActual.setOrden(modulo.getOrden());
			moduloActual.setGrado(modulo.getGrado());
			moduloService.saveModulo(moduloActual);
			return moduloService .findById(id);
				
		}
		// ELIMINAR Modulo
		@DeleteMapping("/{id}")
		public void delete(@PathVariable Long id) {
			moduloService.eliminarModulo(id);
		}
		
		

}
