package com.api.rest.ws.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.rest.ws.dao.IOpcionDao;
import com.api.rest.ws.entities.Opcion;

@Service
public class OpcionServiceImpl implements IOpcionService {

    @Autowired
    private IOpcionDao opcionDao;

    public List<Opcion> findAll() { return (List<Opcion>) opcionDao.findAll(); }

    public Opcion findById(Long id) { return opcionDao.findById(id).orElse(null); }

    public void save(Opcion opcion) { opcionDao.save(opcion); }

    public Opcion editar(Long id) { return opcionDao.findById(id).orElse(null); }

    public void eliminar(Long id) { opcionDao.deleteById(id); }
}
