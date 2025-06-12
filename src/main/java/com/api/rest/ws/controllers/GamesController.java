package com.api.rest.ws.controllers;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.api.rest.ws.entities.Games;
import com.api.rest.ws.services.IGamesService;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/games")
public class GamesController {

    @Autowired
    private IGamesService gamesService;

    @GetMapping
    public List<Games> listar() {
        return gamesService.findAll();
    }

    @GetMapping("/{id}")
    public Games obtener(@PathVariable Long id) {
        return gamesService.findById(id);
    }

    @PostMapping
    public void guardar(@RequestBody Games game) {
        gamesService.save(game);
    }

    @PutMapping("/{id}")
    public Games actualizar(@RequestBody Games game, @PathVariable Long id) {
        Games actual = gamesService.findById(id);
        if (actual != null) {
            actual.setUrl(game.getUrl());
            actual.setTitulo(game.getTitulo());
            actual.setDescripcion(game.getDescripcion());
            actual.setImg(game.getImg());

            gamesService.save(actual);
        }
        return actual;
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        gamesService.eliminar(id);
    }
}
