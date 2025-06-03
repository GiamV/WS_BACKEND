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

import com.api.rest.ws.dao.IGradoDao;
import com.api.rest.ws.entities.Grado;
import com.api.rest.ws.services.GradoServiceImpl;

@ExtendWith(MockitoExtension.class)
public class GradoServiceTest {
	
	@Mock
    private IGradoDao gradoDao;

    @InjectMocks
    private GradoServiceImpl gradoService;

    private Grado grado;

    @BeforeEach
    void setUp() {
        grado = new Grado();
        grado.setIdGrado(1L);
        grado.setGrado("Primero");
    }

    @Test
    @DisplayName("Test para guardar un grado")
    void testGuardarGrado() {
        gradoService.saveGrado(grado);
        verify(gradoDao, times(1)).save(grado);
    }

    @Test
    @DisplayName("Test para listar todos los grados")
    void testListarGrados() {
        List<Grado> lista = Arrays.asList(grado);
        when(gradoDao.findAll()).thenReturn(lista);

        List<Grado> resultado = gradoService.findAll();

        assertThat(resultado).isNotNull();
        assertThat(resultado.size()).isEqualTo(1);
        verify(gradoDao, times(1)).findAll();
    }

    @Test
    @DisplayName("Test para buscar grado por ID")
    void testBuscarGradoPorId() {
        when(gradoDao.findById(1L)).thenReturn(Optional.of(grado));

        Grado resultado = gradoService.findById(1L);

        assertThat(resultado).isNotNull();
        assertThat(resultado.getGrado()).isEqualTo("Primero");
        verify(gradoDao, times(1)).findById(1L);
    }

    @Test
    @DisplayName("Test para eliminar grado por ID")
    void testEliminarGrado() {
        gradoService.eliminarGrado(1L);
        verify(gradoDao, times(1)).deleteById(1L);
    }

}
