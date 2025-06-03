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

import com.api.rest.ws.dao.IGradoDao;
import com.api.rest.ws.entities.Grado;

@SpringBootTest
@ActiveProfiles("test")
public class GradoRepositoryTest {
	
	@Autowired
    private IGradoDao gradoRepository;
	

    @BeforeEach
    void setUp() {
        gradoRepository.deleteAll();
    }

    @DisplayName("Test para guardar un Grado")
    @Test
    void testGuardarGrado() {
        Grado grado = new Grado();
        grado.setGrado("Secundaria");

        Grado guardado = gradoRepository.save(grado);

        assertThat(guardado).isNotNull();
        assertThat(guardado.getIdGrado()).isNotNull();
    }

    @DisplayName("Test para listar los Grados")
    @Test
    void testListarGrados() {
        List<Grado> grados = (List<Grado>) gradoRepository.findAll();
        assertThat(grados).isNotNull();
        assertThat(grados.size()).isEqualTo(0); // cambia a 1 si haces un insert en setUp
    }

    @DisplayName("Test para actualizar un Grado")
    @Test
    void testActualizarGrado() {
        Grado grado = new Grado();
        grado.setGrado("Inicial");
        grado = gradoRepository.save(grado);

        grado.setGrado("Inicial Modificado");
        grado = gradoRepository.save(grado);

        Optional<Grado> actualizado = gradoRepository.findById(grado.getIdGrado());

        assertThat(actualizado).isPresent();
        assertThat(actualizado.get().getGrado()).isEqualTo("Inicial Modificado");
    }

    @DisplayName("Test para eliminar un Grado")
    @Test
    void testEliminarGrado() {
        Grado grado = new Grado();
        grado.setGrado("Eliminarme");
        grado = gradoRepository.save(grado);

        Long id = grado.getIdGrado();
        gradoRepository.deleteById(id);

        Optional<Grado> eliminado = gradoRepository.findById(id);
        assertThat(eliminado).isNotPresent();
    }

}
