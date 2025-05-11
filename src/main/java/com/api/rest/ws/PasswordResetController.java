package com.api.rest.ws;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.*;

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
        redisTemplate.opsForValue().set(token, email, 5, TimeUnit.MINUTES);

        // Crear el enlace para restablecer la contraseña
        String resetLink = "http://localhost:8080/api/password/reset?token=" + token;

        // Crear y enviar el correo electrónico con el token
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setTo(email);
        helper.setSubject("Recuperación de Contraseña");
        helper.setText("Haz clic en el siguiente enlace para restablecer tu contraseña: " + resetLink);

        // Enviar el correo
        mailSender.send(message);

        return "Token enviado al correo: " + email;
    }

    @PostMapping("/reset")
    public String resetPassword(@RequestParam String token, @RequestParam String email, @RequestParam String newPassword) {
        // Verificar si el token existe en Redis y obtener el correo asociado
        String storedEmail = redisTemplate.opsForValue().get(token);

        // Validar que el correo asociado al token coincide con el correo ingresado por el usuario
        if (storedEmail != null && storedEmail.equals(email)) {
            // Aquí puedes agregar la lógica para actualizar la contraseña del usuario
            // Por ejemplo: userService.updatePassword(email, newPassword);

            // Eliminar el token de Redis después de usarlo
            redisTemplate.delete(token);

            return "Contraseña restablecida correctamente.";
        } else {
            return "Token inválido o correo no coincide.";
        }
    }
}