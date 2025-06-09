package com.api.rest.ws.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.rest.ws.dao.ISpeakingDao;
import com.api.rest.ws.entities.Speaking;

@Service
public class SpeakingServiceImpl implements ISpeakingService {

    @Autowired
    private ISpeakingDao speakingDao;

    @Override
    public List<Speaking> findAll() {
        return (List<Speaking>) speakingDao.findAll();
    }

    @Override
    public Speaking findById(Long id) {
        return speakingDao.findById(id).orElse(null);
    }

    @Override
    public void save(Speaking speaking) {
        speakingDao.save(speaking);
    }

    @Override
    public Speaking editar(Long id) {
        return speakingDao.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Long id) {
        speakingDao.deleteById(id);
    }
}
