package com.api.rest.ws.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.rest.ws.dao.IGamesDao;
import com.api.rest.ws.entities.Games;

@Service
public class GamesServiceImpl implements IGamesService {

    @Autowired
    private IGamesDao gamesDao;

    @Override
    public List<Games> findAll() {
        return (List<Games>) gamesDao.findAll();
    }

    @Override
    public Games findById(Long id) {
        return gamesDao.findById(id).orElse(null);
    }

    @Override
    public void save(Games game) {
        gamesDao.save(game);
    }

    @Override
    public Games editar(Long id) {
        return gamesDao.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Long id) {
        gamesDao.deleteById(id);
    }
}
