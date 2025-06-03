package com.api.rest.ws.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.rest.ws.entities.Leccion;
import com.api.rest.ws.entities.Modulo;
import com.api.rest.ws.entities.Progreso_Leccion;
import com.api.rest.ws.services.ILeccionService;
import com.api.rest.ws.services.IPerfilService;
import com.api.rest.ws.services.IProLecService;
import com.api.rest.ws.servicesR.ProLecServiceR;
import com.api.rest.ws.entities.Perfil;

@RestController
@RequestMapping("/prolec")
public class ProLecController {
	
	@Autowired
	private IProLecService prolecService;
	
	@Autowired
	private ILeccionService leccionService;
	
	@Autowired
	private IPerfilService perfilService;
	
	@Autowired
	private ProLecServiceR prolecRService;
	
	// LISTAR 
		@GetMapping("/")
		public List<Progreso_Leccion> listar() {
			return prolecService.findAll();
		}
		
		// BUSCAR POR ID
		@GetMapping("/{id}")
		public Progreso_Leccion prolec(@PathVariable Long id) {
			return prolecService.findById(id);
		}
		//CREAR NUEVO 
		@PostMapping("/nuevoprolec")
		public Progreso_Leccion prolecn(@RequestBody Progreso_Leccion Progreso_Leccion) {
			
			Leccion leccion = leccionService.findById(Long.valueOf(Progreso_Leccion.getLeccion().getIdLeccion() ));
			Progreso_Leccion.setLeccion(leccion);
			Perfil perfil = perfilService.findById(Long.valueOf(Progreso_Leccion.getPerfil().getIdPerfil() ));
			Progreso_Leccion.setPerfil(perfil);

			prolecService.saveProLec(Progreso_Leccion);
			return prolecService.findById(Progreso_Leccion.getIdProgreso_Lec());
		}
		//ACTUALIZAR 
		@PutMapping("/{id}")
			public Progreso_Leccion actualizar(@RequestBody Progreso_Leccion Progreso_Leccion,@PathVariable Long id) {
			Progreso_Leccion Progreso_LeccionActual=prolecService.findById(id);
			Progreso_LeccionActual.setCompletado(Progreso_Leccion.getCompletado());
			Progreso_LeccionActual.setPerfil(Progreso_Leccion.getPerfil());
			Progreso_LeccionActual.setLeccion(Progreso_Leccion.getLeccion());
			prolecService.saveProLec(Progreso_LeccionActual);
				return prolecService.findById(id);
					
			}
		
		// ELIMINAR Modulo
		@DeleteMapping("/{id}")
		public void delete(@PathVariable Long id) {
			prolecService.eliminarProLec(id);
		}
		
		@PostMapping("/marcar-completado")
		public ResponseEntity<Void> marcarCompletado(@RequestParam Long leccion, @RequestParam Long perfil) {
			prolecRService.marcar_completado(leccion, perfil);
		    return ResponseEntity.ok().build();
		}
		
		
	
		
	
	
	

}
