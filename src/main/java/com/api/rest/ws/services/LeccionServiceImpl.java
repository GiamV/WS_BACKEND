package com.api.rest.ws.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.rest.ws.dao.IActividadDao;
import com.api.rest.ws.dao.ILeccionDao;
import com.api.rest.ws.entities.Actividad;
import com.api.rest.ws.entities.Leccion;


@Service
public class LeccionServiceImpl implements ILeccionService {

	@Autowired
	private ILeccionDao leccionDao;
	
	@Override
	public List<Leccion> findAll() {
		// TODO Auto-generated method stub
		return (List<Leccion>)leccionDao.findAll();
	}

	@Override
	public void saveLeccion(Leccion leccion) {
		leccionDao.save(leccion);
		
	}

	@Override
	public Leccion editarLeccion(Long id) {
		// TODO Auto-generated method stub
		return leccionDao.findById(id).orElse(null);
	}

	@Override
	public void eliminarLeccion(Long id) {
		// TODO Auto-generated method stub
		leccionDao.deleteById(id);	
	}

	@Override
	public Leccion findById(Long id) {
		// TODO Auto-generated method stub
		return leccionDao.findById(id).orElse(null);
	}

}
