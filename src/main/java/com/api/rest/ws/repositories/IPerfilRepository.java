package com.api.rest.ws.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.api.rest.ws.entities.Perfil;




public interface IPerfilRepository  extends JpaRepository<Perfil, Long> {
	
	@Query(value= "{call buscar_user_per(:xcoduser)}",nativeQuery=true)
	Perfil findByUser(@Param("xcoduser")Long xcoduser);
	
	

}
