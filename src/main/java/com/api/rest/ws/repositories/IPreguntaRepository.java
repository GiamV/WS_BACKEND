package com.api.rest.ws.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.api.rest.ws.entities.Enunciado;

import jakarta.transaction.Transactional;

public interface IPreguntaRepository extends JpaRepository<Enunciado,Long> {
	
	@Modifying
	@Query(value = "CALL obtener_preguntas(:actividadId)", nativeQuery = true)
	List<Enunciado> obtener_preguntas(@Param("actividadId") Long actividadId);

}
