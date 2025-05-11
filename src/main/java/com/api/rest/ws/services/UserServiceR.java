package com.api.rest.ws.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.rest.ws.entities.Perfil;
import com.api.rest.ws.entities.User;
import com.api.rest.ws.repositories.UserRepository;

@Service
public class UserServiceR {
	
	@Autowired
	UserRepository userRepository;
	
	public List<User> findByUP() {
		return userRepository.findByUserPerfil();
	}

}
