package com.api.rest.ws.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.api.rest.ws.entities.Opcion;
import com.api.rest.ws.entities.Progreso_Actividad;

public interface IProActRepository extends JpaRepository<Progreso_Actividad,Long> {
	
	@Query(value= "{call sp_pro_actividades_por_perfil(:p_id_perfil)}",nativeQuery=true)
	List<Progreso_Actividad> pro_actividad(@Param("p_id_perfil")Long perfilId);


}
