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
import org.mockito.junit.jupiter.MockitoExtension;

import com.api.rest.ws.dao.IModuloDao;
import com.api.rest.ws.entities.Modulo;
import com.api.rest.ws.services.ModuloServiceImpl;

@ExtendWith(MockitoExtension.class)
public class ModuloServiceTest {
	@Mock
    private IModuloDao moduloDao;

    @InjectMocks
    private ModuloServiceImpl moduloService;

    private Modulo modulo;

    @BeforeEach
    void setUp() {
        modulo = new Modulo();
        modulo.setIdModulo(1L);
        modulo.setModulo("Módulo 1");
        modulo.setDescripcion("Descripción del módulo");
        modulo.setOrden(1);
    }

    @Test
    @DisplayName("Test para guardar módulo")
    void testGuardarModulo() {
        moduloService.saveModulo(modulo);
        verify(moduloDao).save(modulo);
    }

    @Test
    @DisplayName("Test para listar módulos")
    void testListarModulos() {
        when(moduloDao.findAll()).thenReturn(Arrays.asList(modulo));
        List<Modulo> lista = moduloService.findAll();
        assertThat(lista).isNotNull();
        assertThat(lista.size()).isEqualTo(1);
        assertThat(lista.get(0).getModulo()).isEqualTo("Módulo 1");
    }

    @Test
    @DisplayName("Test para buscar módulo por ID")
    void testBuscarModuloPorId() {
        when(moduloDao.findById(1L)).thenReturn(Optional.of(modulo));
        Modulo resultado = moduloService.findById(1L);
        assertThat(resultado).isNotNull();
        assertThat(resultado.getModulo()).isEqualTo("Módulo 1");
    }

    @Test
    @DisplayName("Test para eliminar módulo")
    void testEliminarModulo() {
        doNothing().when(moduloDao).deleteById(1L);
        moduloService.eliminarModulo(1L);
        verify(moduloDao, times(1)).deleteById(1L);
    }
	

}
