package br.com.dextra.common.persistence;

import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class EntidadeRepositoryBean implements EntidadeRepository {

	@PersistenceContext(unitName = "sugar-pu")
	protected EntityManager em;

	@Override
	public <T extends Entidade> T buscarPorId(Class<T> classe, Long id) {
		return em.find(classe, id);
	}

	protected Query setaParametrosNaQuery(Query query, Map<String, Object> parametros) {
		for (String identificadorParametro : parametros.keySet()) {
			query.setParameter(identificadorParametro, parametros.get(identificadorParametro));
		}

		return query;
	}

}