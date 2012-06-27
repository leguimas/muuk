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
		hql.append(" where  statusCode = :status ");
		hql.append(" order by expectedCloseDate DESC ");

		Query query = this.em.createQuery(hql.toString());
		query.setParameter("status", status);

		if (status.equals("Ganhamos") || status.equals("Perdemos") || status.equals("OnHold")) {
			query.setMaxResults(6);
		}

		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Opportunity> findByStatus(List<String> status) {
		StringBuilder hql = new StringBuilder();
		hql.append(" from   ").append(Opportunity.class.getName());
		hql.append(" where  statusCode in (:status)");
		hql.append(" order by expectedCloseDate DESC ");

		Query query = this.em.createQuery(hql.toString());
		query.setParameter("status", status);

		return query.getResultList();
	}

}
