package com.api.rest.ws.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.api.rest.ws.dao.IUserDao;
import com.api.rest.ws.entities.User;
import com.api.rest.ws.services.UserService;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
	
	 	@Mock
	    private IUserDao userDao;

	    @InjectMocks
	    private UserService userService;

	    private User user;

	    @BeforeEach
	    void setUp() {
	        user = new User();
	        user.setId(1L);
	        user.setLogin("giam");
	        user.setPassword("123456");
	    }

	    @Test
	    @DisplayName("Test para guardar usuario")
	    void testGuardarUsuario() {
	        userService.saveUser(user);
	        verify(userDao, times(1)).save(user);
	    }

	    @Test
	    @DisplayName("Test para listar usuarios")
	    void testListarUsuarios() {
	        List<User> lista = Arrays.asList(user);
	        when(userDao.findAll()).thenReturn(lista);

	        List<User> resultado = userService.findAll();

	        assertThat(resultado).isNotNull();
	        assertThat(resultado.size()).isEqualTo(1);
	        assertThat(resultado.get(0).getLogin()).isEqualTo("giam");
	        verify(userDao, times(1)).findAll();
	    }

	    @Test
	    @DisplayName("Test para buscar usuario por ID")
	    void testBuscarUsuarioPorId() {
	        when(userDao.findById(1L)).thenReturn(Optional.of(user));

	        User resultado = userService.editarUser(1L);

	        assertThat(resultado).isNotNull();
	        assertThat(resultado.getLogin()).isEqualTo("giam");
	        verify(userDao).findById(1L);
	    }

	    @Test
	    @DisplayName("Test para buscar usuario que no existe")
	    void testBuscarUsuarioNoExiste() {
	        when(userDao.findById(2L)).thenReturn(Optional.empty());

	        User resultado = userService.editarUser(2L);

	        assertThat(resultado).isNull();
	        verify(userDao).findById(2L);
	    }

}
