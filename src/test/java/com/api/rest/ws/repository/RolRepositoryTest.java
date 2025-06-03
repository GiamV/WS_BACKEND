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

import com.api.rest.ws.dao.IRolDao;

import com.api.rest.ws.entities.Rol;


@SpringBootTest
@ActiveProfiles("test")
public class RolRepositoryTest {
	
	@Autowired
    private IRolDao rolRepository;
	
	@BeforeEach
    void setUp() {
        rolRepository.deleteAll(); // Limpiar antes de cada test
    }

    @DisplayName("Test para guardar un Rol")
    @Test
    void testGuardarRol() {
        Rol rol = new Rol();
        rol.setRol("ADMIN");

        rol = rolRepository.save(rol);

        assertThat(rol).isNotNull();
        assertThat(rol.getIdRol()).isNotNull();
        assertThat(rol.getRol()).isEqualTo("ADMIN");
    }

    @DisplayName("Test para listar Roles")
    @Test
    void testListarRoles() {
        List<Rol> roles = (List<Rol>) rolRepository.findAll();

        assertThat(roles).isNotNull();
        assertThat(roles.size()).isEqualTo(0); // Cambia esto si agregas datos en setup
    }

    @DisplayName("Test para actualizar un Rol")
    @Test
    void testActualizarRol() {
        Rol rol = new Rol();
        rol.setRol("USER");
        rol = rolRepository.save(rol);

        rol.setRol("MODERATOR");
        rolRepository.save(rol);

        Optional<Rol> actualizado = rolRepository.findById(rol.getIdRol());

        assertThat(actualizado).isPresent();
        assertThat(actualizado.get().getRol()).isEqualTo("MODERATOR");
    }

    @DisplayName("Test para eliminar un Rol")
    @Test
    void testEliminarRol() {
        Rol rol = new Rol();
        rol.setRol("TO_DELETE");
        rol = rolRepository.save(rol);

        Long id = rol.getIdRol();
        rolRepository.deleteById(id);

        Optional<Rol> eliminado = rolRepository.findById(id);
        assertThat(eliminado).isNotPresent();
    }

}
