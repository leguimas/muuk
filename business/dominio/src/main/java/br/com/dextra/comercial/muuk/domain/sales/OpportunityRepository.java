package br.com.dextra.comercial.muuk.domain.sales;

import java.util.List;

import br.com.dextra.common.persistence.BaseEntityRepository;

public interface OpportunityRepository extends BaseEntityRepository {

	public static final String JNDI_LOCAL = "OpportunityRepository/local";

	public List<Opportunity> findByStatus(String status);

	public List<Opportunity> findByStatus(List<String> status);

}
