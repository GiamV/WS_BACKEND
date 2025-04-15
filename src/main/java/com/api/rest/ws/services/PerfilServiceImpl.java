package com.api.rest.ws.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.rest.ws.dao.IPerfilDao;
import com.api.rest.ws.entities.Perfil;



@Service
public class PerfilServiceImpl implements IPerfilService {
	
	@Autowired
	private IPerfilDao docenteDao;
	


	@Override
	public List<Perfil> findAll() {
		// TODO Auto-generated method stub
		return (List<Perfil>)docenteDao.findAll();
	}

	@Override
	public void savePerfil(Perfil perfil) {
		docenteDao.save(perfil);
		
	}

	@Override
	public Perfil editarPerfil(Long id) {
		return docenteDao.findById(id).orElse(null);
	}

	@Override
	public void eliminarPerfil(Long id) {
		docenteDao.deleteById(id);		
	}

	@Override
	public Perfil findById(Long id) {
		return docenteDao.findById(id).orElse(null);
	}

}
