package com.api.rest.ws;

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
import org.springframework.web.bind.annotation.*;

import com.api.rest.ws.dto.ChangePDto;
import com.api.rest.ws.dto.CredentialsDto;
import com.api.rest.ws.services.TokenService;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@RestController
@RequestMapping("/api/password")
public class PasswordResetController {


    @Autowired
    private JavaMailSender mailSender;  // Inyectamos el servicio de correo

    @Autowired
    private StringRedisTemplate redisTemplate;  // Usamos Redis para manejar los tokens

    // Método para generar y enviar el token por correo
    @PostMapping("/request")
    public String requestPasswordReset(@RequestParam String email) throws MessagingException {
        // Generar un token único
        String token = UUID.randomUUID().toString();

        // Almacenar el token en Redis con un tiempo de expiración de 5 minutos
        redisTemplate.opsForValue().set(token, email, 20, TimeUnit.MINUTES);

        // Crear el enlace para restablecer la contraseña
        String resetLink = "http://localhost:8080/api/password/reset?token=" + token;

        // Crear y enviar el correo electrónico con el token
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setTo(email);
        helper.setSubject("Recuperación de Contraseña");
        helper.setText("Haz clic en el siguiente enlace para restablecer tu contraseña: http://localhost:5173/changepass?token="+token);

        // Enviar el correo
        mailSender.send(message);

        return "Token enviado al correo: " + email;
    }

    @PostMapping("/reset")
    public ResponseEntity<Map<String, String>> resetPassword(@RequestParam String token, @RequestBody ChangePDto changePDto) {
        // Verificar si el token existe en Redis y obtener el correo asociado
        String storedEmail = redisTemplate.opsForValue().get(token);

        // Validar que el correo asociado al token coincide con el correo ingresado por el usuario
        if (storedEmail != null) {
            // Aquí puedes agregar la lógica para actualizar la contraseña del usuario
            // Por ejemplo: userService.updatePassword(email, newPassword)
        	System.out.println("Se verifico correctamente"+changePDto.getNewpassword());
            // Eliminar el token de Redis después de usarlo
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