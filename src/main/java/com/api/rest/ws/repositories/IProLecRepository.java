package com.api.rest.ws.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.api.rest.ws.entities.Perfil;
import com.api.rest.ws.entities.Progreso_Leccion;

import jakarta.transaction.Transactional;

public interface IProLecRepository extends JpaRepository<Progreso_Leccion,Long> {

	@Transactional
	@Modifying
	@Query(value= "{call marcar_completado(:p_id_leccion,:p_id_perfil)}",nativeQuery=true)
	void marcar_completado(@Param("p_id_leccion")Long p_id_leccion,@Param("p_id_perfil")Long p_id_perfil);
}
