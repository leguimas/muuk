package br.com.dextra.common.persistence;

import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class BaseEntityRepositoryBean implements BaseEntityRepository {

	@PersistenceContext(unitName = "sugar-pu")
	protected EntityManager em;

	@Override
	public <T extends BaseEntity> T findByIdId(Class<T> classe, Long id) {
		return em.find(classe, id);
	}

	protected Query setQueryParameters(Query query, Map<String, Object> parameters) {
		for (String parameterId : parameters.keySet()) {
			query.setParameter(parameterId, parameters.get(parameterId));
		}

		return query;
	}

}