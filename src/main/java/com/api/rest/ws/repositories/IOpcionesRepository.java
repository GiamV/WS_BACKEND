package com.api.rest.ws.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.api.rest.ws.entities.Opcion;
import com.api.rest.ws.entities.Perfil;

public interface IOpcionesRepository extends JpaRepository<Opcion,Long> {
	
	@Query(value= "{call obtener_opciones(:preguntaId)}",nativeQuery=true)
	List<Opcion> obtener_opciones(@Param("preguntaId")Long preguntaId);

}
