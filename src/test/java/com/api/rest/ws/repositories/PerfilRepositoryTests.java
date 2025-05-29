package com.api.rest.ws.repositories;


import static org.assertj.core.api.Assertions.assertThat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

import com.api.rest.ws.config.WebConfig;
import com.api.rest.ws.entities.Perfil;

import jakarta.transaction.Transactional;

@SpringBootTest
@Transactional
@Rollback
public class PerfilRepositoryTests {
	
    @MockBean
    private JavaMailSender javaMailSender;
    @MockBean
    private StringRedisTemplate stringRedisTemplate;
	
	@Autowired
	private IPerfilRepository perfilRepository;
	
	
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
        assertThat(perfil.getIdPerfil()).isGreaterThan(0);
        
	}
	
	@DisplayName("Test para listar a los Perfiles")
	@Test
	void testListarPerfil() throws ParseException {

        
        List<Perfil> listaPerfil = perfilRepository.findAll();
        
        assertThat(listaPerfil).isNotNull();
        assertThat(listaPerfil.size()).isEqualTo(6);
        
	}


}
