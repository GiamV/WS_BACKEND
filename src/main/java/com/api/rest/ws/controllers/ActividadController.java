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

import com.api.rest.ws.entities.Actividad;
import com.api.rest.ws.entities.Grado;
import com.api.rest.ws.entities.Modulo;
import com.api.rest.ws.services.IActividadService;
import com.api.rest.ws.services.IModuloService;


@RestController
@RequestMapping("/actividad")
public class ActividadController {
	
	@Autowired
	private IModuloService moduloService;
	@Autowired
	private IActividadService actividadService;
	
	// LISTAR 
		@GetMapping("/")
		public List<Actividad> listar() {
			return actividadService.findAll();
		}
		// BUSCAR  POR ID
		@GetMapping("/{id}")
		public Actividad actividad(@PathVariable Long id) {
			return actividadService.findById(id);
		}
		//CREAR NUEVO 
		@PostMapping("/nuevoactividad")
		public Actividad actividadnew(@RequestBody Actividad actividad) {
			Modulo modulo = moduloService.findById(Long.valueOf(actividad.getModulo().getIdModulo() ));
			actividad.setModulo(modulo);
			actividadService.saveActividad(actividad);
			
			return actividadService.findById(actividad.getIdActividad());
		}
		
		//ACTUALIZAR 
		@PutMapping("/{id}")
		public Actividad actualizar(@RequestBody Actividad actividad,@PathVariable Long id) {
			Actividad actividadActual=actividadService.findById(id);
			actividadActual.setDescripcion(actividad.getDescripcion());
			actividadActual.setTipo(actividad.getTipo());
			actividadActual.setTitulo(actividad.getTitulo());
			actividadActual.setModulo(actividad.getModulo());
			actividadActual.setImg(actividad.getImg());
			actividadService.saveActividad(actividadActual);
			return actividadService .findById(id);
				
		}
		// ELIMINAR Modulo
		@DeleteMapping("/{id}")
		public void delete(@PathVariable Long id) {
			actividadService.eliminarActividad(id);
		}
		
		

}
