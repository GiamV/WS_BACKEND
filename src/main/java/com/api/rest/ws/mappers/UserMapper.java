package com.api.rest.ws.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.api.rest.ws.dto.SignUpDto;
import com.api.rest.ws.dto.UserDto;
import com.api.rest.ws.entities.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
	
	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
	

	UserDto toUserDto(User user); // De entidad a DTO
    User toUser(UserDto userDto); // De DTO a entidad

	@Mapping(target = "password",ignore =true)
	User signUpToUser(SignUpDto userDto);
	

}
