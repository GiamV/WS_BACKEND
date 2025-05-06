package com.api.rest.ws.services;

import java.util.List;


import com.api.rest.ws.entities.User;

public interface IUserService {
	
	public List<User> findAll();

}
