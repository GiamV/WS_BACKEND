package com.api.rest.ws.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doNothing;
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
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.api.rest.ws.dao.IRolDao;
import com.api.rest.ws.entities.Rol;
import com.api.rest.ws.services.RolServiceImpl;


@ExtendWith(MockitoExtension.class)
public class RolServiceTest {
	
	@Mock
    private IRolDao rolDao;

    @InjectMocks
    private RolServiceImpl rolService;

    private Rol rol;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        rol = new Rol();
        rol.setIdRol(1L);
        rol.setRol("Administrador");
    }

    @Test
    @DisplayName("Test para guardar un rol")
    void testGuardarRol() {
        rolService.saveRol(rol);
        verify(rolDao).save(rol);
    }

    @Test
    @DisplayName("Test para listar todos los roles")
    void testListarRoles() {
        when(rolDao.findAll()).thenReturn(Arrays.asList(rol));
        List<Rol> roles = rolService.findAll();
        assertThat(roles).isNotEmpty();
        assertThat(roles.size()).isEqualTo(1);
    }

    @Test
    @DisplayName("Test para buscar un rol por ID")
    void testBuscarRolPorId() {
        when(rolDao.findById(1L)).thenReturn(Optional.of(rol));
        Rol result = rolService.findById(1L);
        assertThat(result).isNotNull();
        assertThat(result.getRol()).isEqualTo("Administrador");
    }

    @Test
    @DisplayName("Test para eliminar un rol por ID")
    void testEliminarRol() {
        doNothing().when(rolDao).deleteById(1L);
        rolService.eliminarRol(1L);
        verify(rolDao, times(1)).deleteById(1L);
    }

}
