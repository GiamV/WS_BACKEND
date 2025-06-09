package com.api.rest.ws.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.api.rest.ws.entities.Speaking;

public interface ISpeakingRepository extends JpaRepository<Speaking,Long> {
	
	@Modifying
	@Query(value = "CALL obtener_speaking(:actividadId)", nativeQuery = true)
	List<Speaking> obtener_speaking(@Param("actividadId") Long actividadId);

}
