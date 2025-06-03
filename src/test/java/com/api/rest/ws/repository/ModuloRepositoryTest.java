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
import com.api.rest.ws.dao.IModuloDao;

import com.api.rest.ws.entities.Grado;
import com.api.rest.ws.entities.Modulo;

@SpringBootTest
@ActiveProfiles("test")
public class ModuloRepositoryTest {
	
	@Autowired
    private IModuloDao moduloRepository;

    @Autowired
    private IGradoDao gradoRepository;

    private Grado grado;

    @BeforeEach
    void setUp() {
        moduloRepository.deleteAll();
        gradoRepository.deleteAll();

        grado = new Grado();
        grado.setGrado("Primero Básico");
        grado = gradoRepository.save(grado);
    }

    @DisplayName("Test para guardar un Módulo")
    @Test
    void testGuardarModulo() {
        Modulo modulo = new Modulo();
        modulo.setModulo("Módulo A");
        modulo.setDescripcion("Este es el módulo A");
        modulo.setOrden(1);
        modulo.setGrado(grado);

        modulo = moduloRepository.save(modulo);

        assertThat(modulo).isNotNull();
        assertThat(modulo.getIdModulo()).isNotNull();
    }

    @DisplayName("Test para listar Módulos")
    @Test
    void testListarModulos() {
        List<Modulo> modulos = (List<Modulo>) moduloRepository.findAll();
        assertThat(modulos).isNotNull();
        assertThat(modulos.size()).isEqualTo(0); // cambia a 1 si haces insert en setup
    }

    @DisplayName("Test para actualizar un Módulo")
    @Test
    void testActualizarModulo() {
        Modulo modulo = new Modulo();
        modulo.setModulo("Módulo X");
        modulo.setDescripcion("Descripción X");
        modulo.setOrden(2);
        modulo.setGrado(grado);

        modulo = moduloRepository.save(modulo);

        modulo.setDescripcion("Descripción actualizada");
        modulo.setOrden(3);
        moduloRepository.save(modulo);

        Optional<Modulo> actualizado = moduloRepository.findById(modulo.getIdModulo());

        assertThat(actualizado).isPresent();
        assertThat(actualizado.get().getDescripcion()).isEqualTo("Descripción actualizada");
        assertThat(actualizado.get().getOrden()).isEqualTo(3);
    }

    @DisplayName("Test para eliminar un Módulo")
    @Test
    void testEliminarModulo() {
        Modulo modulo = new Modulo();
        modulo.setModulo("Eliminarme");
        modulo.setDescripcion("Temporal");
        modulo.setOrden(4);
        modulo.setGrado(grado);

        modulo = moduloRepository.save(modulo);

        Long id = modulo.getIdModulo();
        moduloRepository.deleteById(id);

        Optional<Modulo> eliminado = moduloRepository.findById(id);
        assertThat(eliminado).isNotPresent();
    }
	
	
	
	

}
