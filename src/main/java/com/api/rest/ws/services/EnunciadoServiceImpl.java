package com.api.rest.ws.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.rest.ws.dao.IEnunciadoDao;
import com.api.rest.ws.entities.Enunciado;

@Service
public class EnunciadoServiceImpl implements IEnunciadoService {

    @Autowired
    private IEnunciadoDao preguntaDao;

    @Override
    public List<Enunciado> findAll() {
        return (List<Enunciado>) preguntaDao.findAll();
    }

    @Override
    public Enunciado findById(Long id) {
        return preguntaDao.findById(id).orElse(null);
    }

    @Override
    public void save(Enunciado pregunta) {
        preguntaDao.save(pregunta);
    }

    @Override
    public Enunciado editar(Long id) {
        return preguntaDao.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Long id) {
        preguntaDao.deleteById(id);
    }
}
