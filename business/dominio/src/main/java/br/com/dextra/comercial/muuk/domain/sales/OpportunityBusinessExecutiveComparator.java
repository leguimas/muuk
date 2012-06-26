package br.com.dextra.comercial.muuk.domain.sales;

import java.util.Comparator;

public class OpportunityBusinessExecutiveComparator implements Comparator<Opportunity> {

	@Override
	public int compare(Opportunity anOpportunity, Opportunity anotherOpportunity) {
		return anOpportunity.getBusinessExecutiveName().compareTo(anotherOpportunity.getBusinessExecutiveName());
	}

}
