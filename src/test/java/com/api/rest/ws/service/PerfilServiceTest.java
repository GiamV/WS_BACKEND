package com.api.rest.ws.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.api.rest.ws.dao.IPerfilDao;
import com.api.rest.ws.entities.Perfil;
import com.api.rest.ws.services.PerfilServiceImpl;

@ExtendWith(MockitoExtension.class)
public class PerfilServiceTest {
	
	@Mock
    private IPerfilDao perfilDao;

    @InjectMocks
    private PerfilServiceImpl perfilService;

    private Perfil perfil;

    @BeforeEach
    void setUp() {
        perfil = new Perfil();
        perfil.setIdPerfil(1L);
        perfil.setNombre("Giam");
        perfil.setApellido("Villanueva");
        perfil.setDni("12345678");
        perfil.setSexo("M");
        perfil.setFechanac(new Date());
        perfil.setFotoperfil("giam.jpg");
    }

    @Test
    @DisplayName("Test para guardar un perfil")
    void testGuardarPerfil() {
        perfilService.savePerfil(perfil);
        verify(perfilDao, times(1)).save(perfil);
    }

    @Test
    @DisplayName("Test para listar perfiles")
    void testListarPerfiles() {
        when(perfilDao.findAll()).thenReturn(List.of(perfil));
        List<Perfil> lista = perfilService.findAll();
        assertThat(lista).isNotEmpty();
        assertThat(lista.get(0).getNombre()).isEqualTo("Giam");
    }

    @Test
    @DisplayName("Test para buscar perfil por ID")
    void testBuscarPorId() {
        when(perfilDao.findById(1L)).thenReturn(Optional.of(perfil));
        Perfil resultado = perfilService.findById(1L);
        assertThat(resultado).isNotNull();
        assertThat(resultado.getDni()).isEqualTo("12345678");
    }

    @Test
    @DisplayName("Test para eliminar un perfil")
    void testEliminarPerfil() {
        perfilService.eliminarPerfil(1L);
        verify(perfilDao, times(1)).deleteById(1L);
    }

}
