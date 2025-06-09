package com.api.rest.ws.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.api.rest.ws.dto.EnunciadoDTO;
import com.api.rest.ws.dto.OpcionDTO;
import com.api.rest.ws.dto.PreguntaDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;

@Repository
public class EnunciadoRepository {
	
	 @PersistenceContext
	    private EntityManager entityManager;

	    public EnunciadoDTO obtenerEnunciadoCompleto(Long idActividad) {
	        StoredProcedureQuery query = entityManager
	                .createStoredProcedureQuery("sp_get_enunciado_completo");

	        query.registerStoredProcedureParameter("p_idActividad", Long.class, ParameterMode.IN);
	        query.setParameter("p_idActividad", idActividad);

	        boolean hasResults = query.execute();

	        EnunciadoDTO enunciadoDTO = new EnunciadoDTO();
	        Map<Long, PreguntaDTO> preguntasMap = new HashMap<>();

	        int resultIndex = 0;
	        while (hasResults) {
	            List<Object[]> resultSet = query.getResultList();

	            if (resultIndex == 0 && !resultSet.isEmpty()) {
	                Object[] row = resultSet.get(0);
	                enunciadoDTO.setId(((Number) row[0]).longValue());
	                enunciadoDTO.setEnunciado((String) row[1]);
	                enunciadoDTO.setTipoPregunta((String) row[2]);
	            } else if (resultIndex == 1) {
	                for (Object[] row : resultSet) {
	                    Long idPregunta = ((Number) row[0]).longValue();
	                    String texto = (String) row[1];
	                    PreguntaDTO pregunta = new PreguntaDTO();
	                    pregunta.setId(idPregunta);
	                    pregunta.setTexto(texto);
	                    preguntasMap.put(idPregunta, pregunta);
	                }
	            } else if (resultIndex == 2) {
	                for (Object[] row : resultSet) {
	                    Long idPregunta = ((Number) row[3]).longValue();
	                    OpcionDTO opcion = new OpcionDTO();
	                    opcion.setTextoOpcion((String) row[1]);
	                    opcion.setEsCorrecta(Boolean.TRUE.equals(row[2])); // ✅ más seguro para Boolean o bit
	                    if (preguntasMap.containsKey(idPregunta)) {
	                        preguntasMap.get(idPregunta).getOpciones().add(opcion);
	                    }
	                }
	            }

	            hasResults = query.hasMoreResults();
	            resultIndex++;
	        }

	        enunciadoDTO.setPreguntas(new ArrayList<>(preguntasMap.values()));
	        return enunciadoDTO;
	    }

}
