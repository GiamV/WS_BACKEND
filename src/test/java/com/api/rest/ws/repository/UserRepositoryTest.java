package com.api.rest.ws.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;


import com.api.rest.ws.dao.IUserDao;
import com.api.rest.ws.entities.User;

@SpringBootTest
@ActiveProfiles("test")
public class UserRepositoryTest {
	
	@Autowired
    private IUserDao userRepository;

	
	 @BeforeEach
	    void setUp() {
	        userRepository.deleteAll(); // Limpiar antes de cada test
	    }

	    @DisplayName("Test para guardar un Usuario")
	    @Test
	    void testGuardarUsuario() {
	        User user = new User();
	        user.setLogin("giam123");
	        user.setPassword("segura123");

	        user = userRepository.save(user);

	        assertThat(user).isNotNull();
	        assertThat(user.getId()).isNotNull();
	    }

	    @DisplayName("Test para listar todos los Usuarios")
	    @Test
	    void testListarUsuarios() {
	        List<User> usuarios = (List<User>) userRepository.findAll();

	        assertThat(usuarios).isNotNull();
	        assertThat(usuarios.size()).isEqualTo(0); // Al iniciar está vacío
	    }

	    @DisplayName("Test para actualizar un Usuario")
	    @Test
	    void testActualizarUsuario() {
	        User user = new User();
	        user.setLogin("admin");
	        user.setPassword("admin123");
	        user = userRepository.save(user);

	        user.setPassword("adminModificado");
	        userRepository.save(user);

	        Optional<User> actualizado = userRepository.findById(user.getId());

	        assertThat(actualizado).isPresent();
	        assertThat(actualizado.get().getPassword()).isEqualTo("adminModificado");
	    }

	    @DisplayName("Test para eliminar un Usuario")
	    @Test
	    void testEliminarUsuario() {
	        User user = new User();
	        user.setLogin("eliminarme");
	        user.setPassword("bye123");
	        user = userRepository.save(user);

	        Long id = user.getId();
	        userRepository.deleteById(id);

	        Optional<User> eliminado = userRepository.findById(id);
	        assertThat(eliminado).isNotPresent();
	    }

}
