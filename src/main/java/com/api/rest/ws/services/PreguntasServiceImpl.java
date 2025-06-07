package com.api.rest.ws.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.rest.ws.dao.IPreguntasDao;
import com.api.rest.ws.entities.Preguntas;

@Service
public class PreguntasServiceImpl implements IPreguntasService {

    @Autowired
    private IPreguntasDao preguntasDao;

    @Override
    public List<Preguntas> findAll() {
        return (List<Preguntas>) preguntasDao.findAll();
    }

    @Override
    public Preguntas findById(Long id) {
        return preguntasDao.findById(id).orElse(null);
    }

    @Override
    public void save(Preguntas pregunta) {
        preguntasDao.save(pregunta);
    }

    @Override
    public Preguntas editar(Long id) {
        return preguntasDao.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Long id) {
        preguntasDao.deleteById(id);
    }
}
