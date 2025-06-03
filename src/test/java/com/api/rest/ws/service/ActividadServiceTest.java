package com.api.rest.ws.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
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

import com.api.rest.ws.dao.IActividadDao;
import com.api.rest.ws.entities.Actividad;
import com.api.rest.ws.services.ActividadServiceImpl;

@ExtendWith(MockitoExtension.class)
public class ActividadServiceTest {
	
	@Mock
    private IActividadDao actividadDao;

    @InjectMocks
    private ActividadServiceImpl actividadService;

    private Actividad actividad;

    @BeforeEach
    void setUp() {
        actividad = new Actividad();
        actividad.setIdActividad(1L);
        actividad.setTitulo("Prueba");
        actividad.setDescripcion("Descripción");
        actividad.setTipo(1);
    }

    @Test
    @DisplayName("Test para guardar una actividad")
    void testGuardarActividad() {
        actividadService.saveActividad(actividad);
        verify(actividadDao).save(actividad);
    }

    @Test
    @DisplayName("Test para listar actividades")
    void testListarActividades() {
        when(actividadDao.findAll()).thenReturn(Arrays.asList(actividad));
        List<Actividad> resultado = actividadService.findAll();
        assertNotNull(resultado);
        assertEquals(1, resultado.size());
        verify(actividadDao).findAll();
    }

    @Test
    @DisplayName("Test para encontrar una actividad por ID")
    void testBuscarPorId() {
        when(actividadDao.findById(1L)).thenReturn(Optional.of(actividad));
        Actividad resultado = actividadService.findById(1L);
        assertNotNull(resultado);
        assertEquals(1L, resultado.getIdActividad());
        verify(actividadDao).findById(1L);
    }

    @Test
    @DisplayName("Test para eliminar una actividad")
    void testEliminarActividad() {
        actividadService.eliminarActividad(1L);
        verify(actividadDao).deleteById(1L);
    }

}
