package com.api.rest.ws.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class TokenService {

    @Autowired
    private StringRedisTemplate redisTemplate;  // Usamos StringRedisTemplate para interactuar con Redis

    // Método para generar un token y almacenarlo en Redis con expiración de 5 minutos
    public String generateToken(String email) {
        // Generamos un token único
        String token = UUID.randomUUID().toString();

        // Almacenamos el token en Redis con un tiempo de expiración de 5 minutos
        redisTemplate.opsForValue().set(token, email, 5, TimeUnit.MINUTES);

        // Devolvemos el token generado
        return token;
    }

    // Método para validar el token
    public boolean validateToken(String token) {
        // Verificamos si el token existe en Redis
        String email = redisTemplate.opsForValue().get(token);

        // Si el token no existe, significa que no es válido o ha expirado
        return email != null;
    }

    // Método para usar el token (restablecer la contraseña) y eliminarlo de Redis
    public void useToken(String token, String newPassword) {
        // Verificamos si el token es válido
        if (validateToken(token)) {
            // Aquí puedes agregar la lógica para actualizar la contraseña del usuario
            // Por ejemplo, userService.updatePassword(email, newPassword);
            
            // Eliminamos el token de Redis después de su uso
            redisTemplate.delete(token);
        } else {
            throw new IllegalArgumentException("Token inválido o expirado.");
        }
    }
}
