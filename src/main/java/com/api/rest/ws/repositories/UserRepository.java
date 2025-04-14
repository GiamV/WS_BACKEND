package com.api.rest.ws.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.rest.ws.entities.Docente;
import com.api.rest.ws.entities.User;

@Repository
public interface UserRepository extends JpaRepository <User,Long> {
	
	Optional<User> findByLogin(String login);
	
	public Optional<User> findById(Long id);
	
	

}
