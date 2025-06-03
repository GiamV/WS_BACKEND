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
import com.api.rest.ws.entities.Leccion;
import com.api.rest.ws.entities.Modulo;
import com.api.rest.ws.entities.Progreso_Leccion;
import com.api.rest.ws.services.ILeccionService;
import com.api.rest.ws.services.IModuloService;
import com.api.rest.ws.services.IProLecService;

@RestController
@RequestMapping("/leccion")
public class LeccionController {
	
	@Autowired
	private ILeccionService leccionService;
	@Autowired
	private IModuloService moduloService;
	
	// LISTAR 
	@GetMapping("/")
	public List<Leccion> listar() {
		return leccionService.findAll();
	}
	// BUSCAR POR ID
	@GetMapping("/{id}")
	public Leccion leccion(@PathVariable Long id) {
		return leccionService.findById(id);
	}
	
	//CREAR NUEVO 
	@PostMapping("/nuevoleccion")
	public Leccion leccionnew(@RequestBody Leccion Leccion) {
		
		Modulo modulo = moduloService.findById(Long.valueOf(Leccion.getModulo().getIdModulo() ));
		Leccion.setModulo(modulo);
		leccionService.saveLeccion(Leccion);
		return leccionService.findById(Leccion.getIdLeccion());
	}
	
	//ACTUALIZAR 
		@PutMapping("/{id}")
			public Leccion actualizar(@RequestBody Leccion Leccion,@PathVariable Long id) {
			Leccion leccionActual=leccionService.findById(id);
			leccionActual.setTitulo(Leccion.getTitulo());
			leccionActual.setDescripcion(Leccion.getDescripcion());
			leccionActual.setLeccion(Leccion.getLeccion());
			leccionActual.setTipo(Leccion.getTipo());
			leccionActual.setModulo(Leccion.getModulo());
			leccionService.saveLeccion(leccionActual);
				return leccionService .findById(id);
					
			}
		// ELIMINAR Modulo
				@DeleteMapping("/{id}")
				public void delete(@PathVariable Long id) {
					leccionService.eliminarLeccion(id);
				}


}
