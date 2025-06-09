package com.api.rest.ws.dao;

import org.springframework.data.repository.CrudRepository;
import com.api.rest.ws.entities.Speaking;

public interface ISpeakingDao extends CrudRepository<Speaking, Long> {
}
