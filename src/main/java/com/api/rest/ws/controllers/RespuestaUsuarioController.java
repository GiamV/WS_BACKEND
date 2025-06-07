package com.api.rest.ws.controllers;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.api.rest.ws.entities.RespuestaUsuario;
import com.api.rest.ws.services.IRespuestaUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/api/respuestas")
public class RespuestaUsuarioController {

    @Autowired
    private IRespuestaUsuarioService respuestaService;

    @GetMapping
    public List<RespuestaUsuario> listar() {
        return respuestaService.findAll();
    }

    @GetMapping("/{id}")
    public RespuestaUsuario obtener(@PathVariable Long id) {
        return respuestaService.findById(id);
    }

    @PostMapping
    public void guardar(@RequestBody RespuestaUsuario respuesta) {
        respuestaService.save(respuesta);
    }

    @PutMapping("/{id}")
    public RespuestaUsuario actualizar(@RequestBody RespuestaUsuario respuesta, @PathVariable Long id) {
        RespuestaUsuario actual = respuestaService.findById(id);
        if (actual != null) {
            actual.setPerfil(respuesta.getPerfil());
            actual.setPregunta(respuesta.getPregunta());
            actual.setRespuestaTexto(respuesta.getRespuestaTexto());
            actual.setRespuestaAudioUrl(respuesta.getRespuestaAudioUrl());
            actual.setEsCorrecta(respuesta.getEsCorrecta());
            actual.setFechaRespuesta(respuesta.getFechaRespuesta());

            respuestaService.save(actual);
        }
        return actual;
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        respuestaService.eliminar(id);
    }
}
