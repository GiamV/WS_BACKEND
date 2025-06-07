package com.api.rest.ws.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.rest.ws.dao.IPreguntaDao;
import com.api.rest.ws.entities.Pregunta;

@Service
public class PreguntaServiceImpl implements IPreguntaService {

    @Autowired
    private IPreguntaDao preguntaDao;

    @Override
    public List<Pregunta> findAll() {
        return (List<Pregunta>) preguntaDao.findAll();
    }

    @Override
    public Pregunta findById(Long id) {
        return preguntaDao.findById(id).orElse(null);
    }

    @Override
    public void save(Pregunta pregunta) {
        preguntaDao.save(pregunta);
    }

    @Override
    public Pregunta editar(Long id) {
        return preguntaDao.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Long id) {
        preguntaDao.deleteById(id);
    }
}
