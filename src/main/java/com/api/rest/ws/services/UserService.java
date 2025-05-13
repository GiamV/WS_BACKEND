package com.api.rest.ws.services;

import java.nio.CharBuffer;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.api.rest.ws.dao.IRolDao;
import com.api.rest.ws.dao.IUserDao;
import com.api.rest.ws.dto.CredentialsDto;
import com.api.rest.ws.dto.SignUpDto;

import com.api.rest.ws.dto.UserDto;
import com.api.rest.ws.entities.Rol;
import com.api.rest.ws.entities.User;
import com.api.rest.ws.exceptions.AppException;
import com.api.rest.ws.mappers.UserMapper;
import com.api.rest.ws.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService implements IUserService {
	
	@Autowired
	private IUserDao userDao;

	@Autowired
    private  UserRepository userRepository;
	@Autowired
    private  UserMapper userMapper;
	@Autowired
    private  PasswordEncoder passwordEncoder;

    public UserDto findByLogin(String login) {
        User user = userRepository.findByLogin(login)
            .orElseThrow(() -> new AppException("Unknown user", HttpStatus.NOT_FOUND));
        return userMapper.toUserDto(user);
    }
    
    
    public UserDto login(CredentialsDto credentialsDto) {
        User user = userRepository.findByLogin(credentialsDto.getLogin())
            .orElseThrow(() -> new AppException("Unknown user", HttpStatus.NOT_FOUND));

        if (passwordEncoder.matches(CharBuffer.wrap(credentialsDto.getPassword()), user.getPassword())) {
            return userMapper.toUserDto(user);
        }

        throw new AppException("Invalid password", HttpStatus.BAD_REQUEST);
    }
    
    public UserDto register(SignUpDto userDto) {
        Optional<User> optionalUser = userRepository.findByLogin(userDto.getLogin());

        if (optionalUser.isPresent()) {
            throw new AppException("Login already exists", HttpStatus.BAD_REQUEST);
        }

        User user = userMapper.signUpToUser(userDto);
        
        user.setPassword(passwordEncoder.encode(CharBuffer.wrap(userDto.getPassword())));

        User savedUser = userRepository.save(user);
        
        return userMapper.toUserDto(user);
    }
    
    public User findById(Long id) {
  
        return userRepository.findById(id)
                .orElseThrow(() -> new AppException("Unknown user", HttpStatus.NOT_FOUND));
    }


	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return (List<User>)userDao.findAll();
	}


	@Override
	public void saveUser(User user) {
		userDao.save(user);
		
	}


	@Override
	public User editarUser(Long id) {
		// TODO Auto-generated method stub
		return userDao.findById(id).orElse(null);
	}
	
	
	
	


	
    
    

    
    
     

    
}
