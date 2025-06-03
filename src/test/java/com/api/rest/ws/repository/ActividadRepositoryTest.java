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
import com.api.rest.ws.dao.IModuloDao;
import com.api.rest.ws.entities.Actividad;
import com.api.rest.ws.entities.Modulo;


@SpringBootTest
@ActiveProfiles("test")
public class ActividadRepositoryTest {
	
	@Autowired
    private IActividadDao actividadRepository;
	
	@Autowired
    private IModuloDao moduloRepository;

    private Modulo modulo;

    @BeforeEach
    void setUp() {
        actividadRepository.deleteAll();
        moduloRepository.deleteAll();

        // Crear y guardar un módulo para usar en las actividades
        modulo = new Modulo();
        modulo.setModulo("Módulo 1");
        modulo.setDescripcion("Descripción del módulo");
        modulo.setOrden(1);
        modulo = moduloRepository.save(modulo);
    }

    @Test
    @DisplayName("Guardar actividad")
    void testGuardarActividad() {
        Actividad actividad = new Actividad();
        actividad.setTitulo("Actividad 1");
        actividad.setDescripcion("Descripción 1");
        actividad.setTipo(1);
        actividad.setModulo(modulo);

        Actividad guardada = actividadRepository.save(actividad);

        assertThat(guardada).isNotNull();
        assertThat(guardada.getIdActividad()).isNotNull();
    }

    @Test
    @DisplayName("Listar actividades")
    void testListarActividades() {
        List<Actividad> actividades = (List<Actividad>) actividadRepository.findAll();
        assertThat(actividades).isNotNull();
        assertThat(actividades.size()).isEqualTo(0); // cambia si creas en setUp
    }

    @Test
    @DisplayName("Actualizar actividad")
    void testActualizarActividad() {
        Actividad actividad = new Actividad();
        actividad.setTitulo("Antiguo");
        actividad.setDescripcion("Texto");
        actividad.setTipo(1);
        actividad.setModulo(modulo);
        actividad = actividadRepository.save(actividad);

        actividad.setTitulo("Actualizado");
        actividad = actividadRepository.save(actividad);

        Optional<Actividad> actualizada = actividadRepository.findById(actividad.getIdActividad());
        assertThat(actualizada).isPresent();
        assertThat(actualizada.get().getTitulo()).isEqualTo("Actualizado");
    }

    @Test
    @DisplayName("Eliminar actividad")
    void testEliminarActividad() {
        Actividad actividad = new Actividad();
        actividad.setTitulo("Eliminarme");
        actividad.setDescripcion("Borrar");
        actividad.setTipo(2);
        actividad.setModulo(modulo);
        actividad = actividadRepository.save(actividad);

        Long id = actividad.getIdActividad();
        actividadRepository.deleteById(id);

        Optional<Actividad> eliminada = actividadRepository.findById(id);
        assertThat(eliminada).isNotPresent();
    }

}
