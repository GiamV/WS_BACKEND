package com.api.rest.ws.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.ActiveProfiles;


import com.api.rest.ws.dao.IPerfilDao;
import com.api.rest.ws.entities.Perfil;


@SpringBootTest
@ActiveProfiles("test")

public class PerfilRepositoryTests {


	
    @Autowired
    private IPerfilDao perfilRepository;

	
    @BeforeEach
    void setUp() { 
	}
    
	@DisplayName("Test para guardar un Perfil")
	@Test
	void testGuardarPerfil() throws ParseException {
        Perfil perfil = new Perfil();
        perfil.setNombre("Giam");
        perfil.setApellido("Villanueva");
        perfil.setDni("12345678");
        perfil.setSexo("M");

        // Fecha de nacimiento con formato yyyy-MM-dd
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaNacimiento = sdf.parse("2000-01-01");
        perfil.setFechanac(fechaNacimiento);

        perfil.setFotoperfil("giam.jpg");
        perfilRepository.save(perfil);
        
        assertThat(perfil).isNotNull();        
	}
	@DisplayName("Test para listar a los Perfiles")
	@Test
	void testListarPerfil() throws ParseException {

        
        List<Perfil> listaPerfil = (List<Perfil>) perfilRepository.findAll();
        
        assertThat(listaPerfil).isNotNull();
        assertThat(listaPerfil.size()).isEqualTo(1);
        
	}


	@DisplayName("Test para actualizar un Perfil")
	@Test
	void testActualizarPerfil() throws ParseException {
	    // Guardar primero un perfil
	    Perfil perfil = new Perfil();
	    perfil.setNombre("Carlos");
	    perfil.setApellido("Ramírez");
	    perfil.setDni("87654321");
	    perfil.setSexo("M");

	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    perfil.setFechanac(sdf.parse("1995-08-20"));
	    perfil.setFotoperfil("carlos.jpg");

	    perfil = perfilRepository.save(perfil);

	    // Actualizar nombre y apellido
	    perfil.setNombre("Carlos A.");
	    perfil.setApellido("Ramírez Díaz");
	    perfilRepository.save(perfil);

	    // Verificar
	    Optional<Perfil> perfilActualizado = perfilRepository.findById(perfil.getIdPerfil());

	    assertThat(perfilActualizado).isPresent();
	    assertThat(perfilActualizado.get().getNombre()).isEqualTo("Carlos A.");
	    assertThat(perfilActualizado.get().getApellido()).isEqualTo("Ramírez Díaz");
	}
	
	
	@DisplayName("Test para eliminar un Perfil")
	@Test
	void testEliminarPerfil() throws ParseException {
	    // Guardar primero un perfil
	    Perfil perfil = new Perfil();
	    perfil.setNombre("Laura");
	    perfil.setApellido("Mendoza");
	    perfil.setDni("99999999");
	    perfil.setSexo("F");

	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    perfil.setFechanac(sdf.parse("1990-03-15"));
	    perfil.setFotoperfil("laura.jpg");

	    perfil = perfilRepository.save(perfil);

	    Long id = perfil.getIdPerfil();

	    // Eliminar
	    perfilRepository.deleteById(id);

	    // Verificar que ya no exista
	    Optional<Perfil> perfilEliminado = perfilRepository.findById(id);
	    assertThat(perfilEliminado).isNotPresent();
	}

	
	


}
