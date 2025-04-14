package com.api.rest.ws.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.rest.ws.dao.IDocenteDao;
import com.api.rest.ws.entities.Docente;



@Service
public class DocenteServiceImpl implements IDocenteService {
	
	@Autowired
	private IDocenteDao docenteDao;
	


	@Override
	public List<Docente> findAll() {
		// TODO Auto-generated method stub
		return (List<Docente>)docenteDao.findAll();
	}

	@Override
	public void saveDocente(Docente docente) {
		docenteDao.save(docente);
		
	}

	@Override
	public Docente editarDocente(Long id) {
		return docenteDao.findById(id).orElse(null);
	}

	@Override
	public void eliminarDocente(Long id) {
		docenteDao.deleteById(id);		
	}

	@Override
	public Docente findById(Long id) {
		return docenteDao.findById(id).orElse(null);
	}

}
