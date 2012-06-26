package br.com.dextra.common.rest.config;

import java.util.HashSet;
import java.util.Set;

import br.com.dextra.comercial.muuk.web.opportunity.OpportunityRS;
import br.com.dextra.common.security.SecurityRS;

public class Application extends javax.ws.rs.core.Application {

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> classes = new HashSet<Class<?>>();
		classes.add(SecurityRS.class);
		classes.add(OpportunityRS.class);
		return classes;
	}

	@Override
	public Set<Object> getSingletons() {
		Set<Object> singletons = new HashSet<Object>();
		return singletons;
	}
}
