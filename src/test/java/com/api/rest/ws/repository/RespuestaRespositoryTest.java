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

import com.api.rest.ws.dao.IActividadDao;
import com.api.rest.ws.dao.IPerfilDao;
import com.api.rest.ws.dao.IRespuestaDao;

import com.api.rest.ws.entities.Actividad;
import com.api.rest.ws.entities.Perfil;
import com.api.rest.ws.entities.Respuesta;

@SpringBootTest
@ActiveProfiles("test")
public class RespuestaRespositoryTest {
	
	@Autowired
    private IRespuestaDao respuestaRepository;

    @Autowired
    private IPerfilDao perfilRepository;

    @Autowired
    private IActividadDao actividadRepository;

    private Perfil perfil;
    private Actividad actividad;

    @BeforeEach
    void setUp() {
        respuestaRepository.deleteAll();
        actividadRepository.deleteAll();
        perfilRepository.deleteAll();

        perfil = new Perfil();
        perfil.setNombre("Giam");
        perfil.setApellido("Villanueva");
        perfil.setDni("12345678");
        perfil.setSexo("M");
        perfil.setFechanac(java.sql.Date.valueOf("2000-01-01"));
        perfil.setFotoperfil("foto.jpg");
        perfil = perfilRepository.save(perfil);

        actividad = new Actividad();
        actividad.setTitulo("Actividad 1");
        actividad.setDescripcion("Descripción de prueba");
        actividad = actividadRepository.save(actividad);
    }

    @DisplayName("Test para guardar una Respuesta")
    @Test
    void testGuardarRespuesta() {
        Respuesta r = new Respuesta();
        r.setRespuesta("Respuesta A");
        r.setEs_correcta(true);
        r.setPerfil(perfil);
        r.setActividad(actividad);

        r = respuestaRepository.save(r);

        assertThat(r).isNotNull();
        assertThat(r.getIdRespuesta()).isNotNull();
    }

    @DisplayName("Test para listar Respuestas")
    @Test
    void testListarRespuestas() {
        List<Respuesta> respuestas = (List<Respuesta>) respuestaRepository.findAll();
        assertThat(respuestas).isNotNull();
        assertThat(respuestas.size()).isEqualTo(0);
    }

    @DisplayName("Test para actualizar una Respuesta")
    @Test
    void testActualizarRespuesta() {
        Respuesta r = new Respuesta();
        r.setRespuesta("Original");
        r.setEs_correcta(false);
        r.setPerfil(perfil);
        r.setActividad(actividad);
        r = respuestaRepository.save(r);

        r.setRespuesta("Actualizada");
        r.setEs_correcta(true);
        respuestaRepository.save(r);

        Optional<Respuesta> actualizada = respuestaRepository.findById(r.getIdRespuesta());

        assertThat(actualizada).isPresent();
        assertThat(actualizada.get().getRespuesta()).isEqualTo("Actualizada");
        assertThat(actualizada.get().getEs_correcta()).isTrue();
    }

    @DisplayName("Test para eliminar una Respuesta")
    @Test
    void testEliminarRespuesta() {
        Respuesta r = new Respuesta();
        r.setRespuesta("Eliminar esta");
        r.setEs_correcta(false);
        r.setPerfil(perfil);
        r.setActividad(actividad);
        r = respuestaRepository.save(r);

        Long id = r.getIdRespuesta();
        respuestaRepository.deleteById(id);

        Optional<Respuesta> eliminada = respuestaRepository.findById(id);
        assertThat(eliminada).isNotPresent();
    }

}
