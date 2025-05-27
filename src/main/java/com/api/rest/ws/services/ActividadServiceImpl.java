package com.api.rest.ws.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.api.rest.ws.dao.IActividadDao;
import com.api.rest.ws.dao.IPerfilDao;
import com.api.rest.ws.entities.Actividad;
import com.api.rest.ws.entities.Perfil;

public class ActividadServiceImpl implements IActividadService {

	@Autowired
	private IActividadDao actividadDao;
	
	@Override
	public List<Actividad> findAll() {
		// TODO Auto-generated method stub
		return (List<Actividad>)actividadDao.findAll();
	}

	@Override
	public void saveActividad(Actividad actividad) {
		actividadDao.save(actividad);
		
	}

	@Override
	public Actividad editarActividad(Long id) {
		// TODO Auto-generated method stub
		return actividadDao.findById(id).orElse(null);
	}

	@Override
	public void eliminarActividad(Long id) {
		// TODO Auto-generated method stub
		actividadDao.deleteById(id);	
	}

	@Override
	public Actividad findById(Long id) {
		// TODO Auto-generated method stub
		return actividadDao.findById(id).orElse(null);
	}

}
