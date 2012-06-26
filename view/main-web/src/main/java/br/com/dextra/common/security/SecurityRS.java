package br.com.dextra.common.security;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import br.com.dextra.security.AuthenticationDataHolder;

@Path("/security")
public class SecurityRS {

	@GET
	@Path("/logged-user")
	public String getLoggedUser() {
		return AuthenticationDataHolder.get().getUsername();
	}

}
