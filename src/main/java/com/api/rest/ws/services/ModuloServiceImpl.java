package com.api.rest.ws.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.rest.ws.dao.IModuloDao;
import com.api.rest.ws.entities.Modulo;


@Service
public class ModuloServiceImpl implements IModuloService {
	@Autowired
	private IModuloDao moduloDao;

	@Override
	public List<Modulo> findAll() {
		// TODO Auto-generated method stub
		return (List<Modulo>)moduloDao.findAll();
	}

	@Override
	public void saveModulo(Modulo modulo) {
		moduloDao.save(modulo);
		
	}

	@Override
	public Modulo editarModulo(Long id) {
		// TODO Auto-generated method stub
		return moduloDao.findById(id).orElse(null);
	}

	@Override
	public void eliminarModulo(Long id) {
		moduloDao.deleteById(id);	
		
	}

	@Override
	public Modulo findById(Long id) {
		// TODO Auto-generated method stub
		return moduloDao.findById(id).orElse(null);
	}

}
