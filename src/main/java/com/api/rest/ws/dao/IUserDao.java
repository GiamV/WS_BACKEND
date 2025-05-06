package com.api.rest.ws.dao;

import org.springframework.data.repository.CrudRepository;

import com.api.rest.ws.entities.User;

public interface IUserDao extends CrudRepository<User,Long> {

}
