package com.api.rest.ws.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.rest.ws.dao.IGradoDao;
import com.api.rest.ws.entities.Grado;

@Service
public class GradoServiceImpl implements IGradoService {
	
	@Autowired
	private IGradoDao gradoDao;

	@Override
	public List<Grado> findAll() {
		// TODO Auto-generated method stub
		return (List<Grado>)gradoDao.findAll();
	}

	@Override
	public void saveGrado(Grado grado) {
		gradoDao.save(grado);
		
	}

	@Override
	public Grado editarGrado(Long id) {
		// TODO Auto-generated method stub
		return gradoDao.findById(id).orElse(null);
	}

	@Override
	public void eliminarGrado(Long id) {
		// TODO Auto-generated method stub
		gradoDao.deleteById(id);
	}

	@Override
	public Grado findById(Long id) {
		// TODO Auto-generated method stub
		return gradoDao.findById(id).orElse(null);
	}

}
