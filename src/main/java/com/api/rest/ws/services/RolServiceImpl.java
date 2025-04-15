package com.api.rest.ws.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.rest.ws.dao.IPerfilDao;
import com.api.rest.ws.dao.IRolDao;

import com.api.rest.ws.entities.Rol;

@Service
public class RolServiceImpl implements IRolService {
	
	@Autowired
	private IRolDao rolDao;

	@Override
	public List<Rol> findAll() {
		// TODO Auto-generated method stub
		return (List<Rol>)rolDao.findAll();
	}

	@Override
	public void saveRol(Rol rol) {
		rolDao.save(rol);
	}

	@Override
	public Rol editarRol(Long id) {
		return rolDao.findById(id).orElse(null);
	}

	@Override
	public void eliminarRol(Long id) {
		rolDao.deleteById(id);	
		
	}

	@Override
	public Rol findById(Long id) {
		return rolDao.findById(id).orElse(null);
	}

}
