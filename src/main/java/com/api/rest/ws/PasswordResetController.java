package com.api.rest.ws;

import java.nio.CharBuffer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.api.rest.ws.dto.ChangePDto;
import com.api.rest.ws.dto.CredentialsDto;
import com.api.rest.ws.dto.PerfilDto;
import com.api.rest.ws.entities.Perfil;
import com.api.rest.ws.entities.User;
import com.api.rest.ws.services.TokenService;
import com.api.rest.ws.services.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@RestController
@RequestMapping("/api/password")
public class PasswordResetController {

	
	@Autowired
	private UserService userService;
	
	@Autowired
    private  PasswordEncoder passwordEncoder;

    @Autowired
    private JavaMailSender mailSender;  // Inyectamos el servicio de correo

    @Autowired
    private StringRedisTemplate redisTemplate;  // Usamos Redis para manejar los tokens

    // Método para generar y enviar el token por correo
    @PostMapping("/request")
    public String requestPasswordReset(@RequestParam String email, @RequestBody ChangePDto changePDto) throws MessagingException, JsonProcessingException {
        // Generar un token único
        String token = UUID.randomUUID().toString();
        System.out.println("Se verifico correctamente"+changePDto.getId());
        

        Map<String, String> data = new HashMap<>();
        data.put("email", email);
        data.put("id", String.valueOf(changePDto.getId()));

        // Guarda todo como JSON en Redis
        String jsonData = new ObjectMapper().writeValueAsString(data);
        redisTemplate.opsForValue().set(token, jsonData, 20, TimeUnit.MINUTES);

        // Enlace de restablecimiento
        String resetLink = "http://localhost:5173/changepass?token=" + token;

        // Crear el mensaje de correo
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

        helper.setTo(email);
        helper.setSubject("Recuperación de Contraseña");

        // Cuerpo HTML del correo
        String htmlContent = "<!DOCTYPE html>"
                + "<html><head><meta charset='UTF-8'><title>Recuperación de Contraseña</title></head>"
                + "<body style='font-family: Arial, sans-serif; background-color: #f4f4f4; padding: 20px;'>"
                + "<div style='max-width: 600px; margin: auto; background: white; padding: 20px; border-radius: 8px;'>"
                + "<h2 style='color: #333;'>Solicitud para restablecer tu contraseña</h2>"
                + "<p>Hola,</p>"
                + "<p>Recibimos una solicitud para restablecer la contraseña de tu cuenta. Si tú hiciste esta solicitud, haz clic en el botón a continuación. De lo contrario, puedes ignorar este mensaje.</p>"
                + "<a href='" + resetLink + "' "
                + "style='display: inline-block; padding: 12px 24px; margin-top: 20px; color: white; background-color: #007BFF; text-decoration: none; border-radius: 5px;'>"
                + "Restablecer contraseña</a>"
                + "<p style='margin-top: 30px; font-size: 12px; color: #666;'>"
                + "Este enlace expirará en 20 minutos por razones de seguridad."
                + "</p>"
                + "<p style='font-size: 12px; color: #999;'>Si tienes problemas, copia y pega el siguiente enlace en tu navegador:</p>"
                + "<p style='font-size: 12px; color: #999;'>" + resetLink + "</p>"
                + "</div></body></html>";

        helper.setText(htmlContent, true); // true para indicar que es HTML

        mailSender.send(message);

        return "Token enviado al correo: " + email;
    }

    @PostMapping("/reset")
    public ResponseEntity<Map<String, String>> resetPassword(@RequestParam String token, @RequestBody ChangePDto changePDto) throws JsonMappingException, JsonProcessingException {
        // Verificar si el token existe en Redis y obtener el correo asociado
    	String jsonData = redisTemplate.opsForValue().get(token);
    	
    	

        // Validar que el correo asociado al token coincide con el correo ingresado por el usuario
        if (jsonData != null) {
        	// Convertir el JSON a un Map
            ObjectMapper mapper = new ObjectMapper();
            Map<String, String> data = mapper.readValue(jsonData, Map.class);

            String email = data.get("email");
            String id = data.get("id");

            // Aquí puedes usar el ID y el correo
            System.out.println("Email: " + email);
            System.out.println("ID del usuario: " + id);
            System.out.println(changePDto.getNewpassword());
            
            
            User useractual=userService.findById(Long.parseLong(id));
            useractual.setPassword(passwordEncoder.encode(CharBuffer.wrap(changePDto.getNewpassword())));
            userService.saveUser(useractual);
    		

            
            // Aquí va tu lógica para cambiar la contraseña
            // Por ejemplo: userService.updatePassword(Long.parseLong(id), changePDto.getNewpassword());

            redisTemplate.delete(token);

            Map<String, String> response = new HashMap<>();
            response.put("message", "Contraseña restablecida correctamente.");
            return ResponseEntity.ok(response);
        } else {
            // Devolver una respuesta con código 400 (Bad Request) si el token o el correo no coinciden
            return ResponseEntity.status(400).body(Collections.singletonMap("error", "Token inválido o correo no coincide."));  // HTTP 400 Bad Request
        }
    }
}