package com.api.rest.ws.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.rest.ws.dao.IActividadDao;
import com.api.rest.ws.dao.IProLecDao;
import com.api.rest.ws.entities.Actividad;
import com.api.rest.ws.entities.Progreso_Leccion;
import com.api.rest.ws.repositories.IProLecRepository;


@Service
public class LecProServiceImpl implements IProLecService {

	
	@Autowired
	private IProLecDao prolecDao;
	@Autowired
	private IProLecRepository prolecSQL;
	
	
	@Override
	public List<Progreso_Leccion> findAll() {
		// TODO Auto-generated method stub
		return (List<Progreso_Leccion>)prolecDao.findAll();
	}

	@Override
	public void saveProLec(Progreso_Leccion progreso_Leccion) {
		// TODO Auto-generated method stub
		prolecDao.save(progreso_Leccion);
	}

	@Override
	public Progreso_Leccion editarProLec(Long id) {
		// TODO Auto-generated method stub
		return prolecDao.findById(id).orElse(null);
	}

	@Override
	public void eliminarProLec(Long id) {
		// TODO Auto-generated method stub
		prolecDao.deleteById(id);	
	}

	@Override
	public Progreso_Leccion findById(Long id) {
		return prolecDao.findById(id).orElse(null);
	}
	
	

}
