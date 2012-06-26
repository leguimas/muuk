package br.com.dextra.comercial.muuk.domain.sales;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import org.mycontainer.annotation.MycontainerLocalBinding;

import br.com.dextra.common.persistence.BaseEntityRepositoryBean;

@Stateless
@MycontainerLocalBinding(value = OpportunityRepository.JNDI_LOCAL)
public class OpportunityRepositoryBean extends BaseEntityRepositoryBean implements OpportunityRepository {

	@SuppressWarnings("unchecked")
	@Override
	public List<Opportunity> findByStatus(String status) {
		StringBuilder hql = new StringBuilder();
		hql.append(" from   ").append(Opportunity.class.getName());
		hql.append(" where  statusCode = :status");

		Query query = this.em.createQuery(hql.toString());
		query.setParameter("status", status);

		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Opportunity> findByStatus(List<String> status) {
		StringBuilder hql = new StringBuilder();
		hql.append(" from   ").append(Opportunity.class.getName());
		hql.append(" where  statusCode in (:status)");

		Query query = this.em.createQuery(hql.toString());
		query.setParameter("status", status);

		return query.getResultList();
	}

}
