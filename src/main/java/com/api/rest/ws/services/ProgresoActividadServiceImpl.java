package com.api.rest.ws.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.rest.ws.dao.IProgresoActividadDao;
import com.api.rest.ws.entities.Progreso_Actividad;

@Service
public class ProgresoActividadServiceImpl implements IProgresoActividadService {

    @Autowired
    private IProgresoActividadDao progresoDao;

    @Override
    public List<Progreso_Actividad> findAll() {
        return (List<Progreso_Actividad>) progresoDao.findAll();
    }

    @Override
    public Progreso_Actividad findById(Long id) {
        return progresoDao.findById(id).orElse(null);
    }

    @Override
    public void save(Progreso_Actividad progreso) {
        progresoDao.save(progreso);
    }

    @Override
    public Progreso_Actividad editar(Long id) {
        return progresoDao.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Long id) {
        progresoDao.deleteById(id);
    }
}
