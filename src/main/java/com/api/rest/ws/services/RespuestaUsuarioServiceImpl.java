package com.api.rest.ws.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.rest.ws.dao.IRespuestaUsuarioDao;
import com.api.rest.ws.entities.RespuestaUsuario;

@Service
public class RespuestaUsuarioServiceImpl implements IRespuestaUsuarioService {

    @Autowired
    private IRespuestaUsuarioDao respuestaDao;

    @Override
    public List<RespuestaUsuario> findAll() {
        return (List<RespuestaUsuario>) respuestaDao.findAll();
    }

    @Override
    public RespuestaUsuario findById(Long id) {
        return respuestaDao.findById(id).orElse(null);
    }

    @Override
    public void save(RespuestaUsuario respuesta) {
        respuestaDao.save(respuesta);
    }

    @Override
    public RespuestaUsuario editar(Long id) {
        return respuestaDao.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Long id) {
        respuestaDao.deleteById(id);
    }
}
