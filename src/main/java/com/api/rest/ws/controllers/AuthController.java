package com.api.rest.ws.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.rest.ws.config.UserAuthProvider;
import com.api.rest.ws.dto.CredentialsDto;
import com.api.rest.ws.dto.SignUpDto;
import com.api.rest.ws.dto.UserDto;
import com.api.rest.ws.services.UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class AuthController {

	

    private final UserService userService;
    private final UserAuthProvider userAuthProvider;


    public AuthController(UserService userService, UserAuthProvider userAuthProvider) {
        this.userService = userService;
        this.userAuthProvider = userAuthProvider;}
        

    @PostMapping("/Login")
    public ResponseEntity<UserDto> login(@RequestBody CredentialsDto credentialsDto) {
        UserDto user = userService.login(credentialsDto); // Verifica que el login funcione correctamente
        user.setToken(userAuthProvider.createToken(user.getLogin())); // Solo se debe hacer si el login es válido
        return ResponseEntity.ok(user);
    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@RequestBody SignUpDto signUpDto) {
        UserDto user = userService.register(signUpDto);  // Solo registrar el usuario
        return ResponseEntity.created(URI.create("/users/" + user.getId()))
                .body(user);
    }
}

