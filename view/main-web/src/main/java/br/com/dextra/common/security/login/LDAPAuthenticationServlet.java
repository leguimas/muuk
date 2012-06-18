package br.com.dextra.common.security.login;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import br.com.dextra.security.AuthenticationData;
import br.com.dextra.security.UsernameAndPasswordAuthenticationServlet;
import br.com.dextra.security.exceptions.AuthenticationFailedException;

public class LDAPAuthenticationServlet extends UsernameAndPasswordAuthenticationServlet {

	private static final long serialVersionUID = -5300898857531376025L;

	private static final String DEFAULT_PROVIDER = "MUUK";

	private static final String URL_PARAMETER = "ldapURL";

	private String ldapUrl = null;

	@Override
	public void init(ServletConfig config) throws ServletException {
		ldapUrl = config.getInitParameter(URL_PARAMETER);
	}

	@Override
	protected ClassLoader getClassLoaderForConfiguration() {
		return this.getClass().getClassLoader();
	}

	@Override
	protected AuthenticationData authenticate(HttpServletRequest servletRequest, String username, String password)
			throws AuthenticationFailedException {

		Hashtable<String, String> env = new Hashtable<String, String>();
		env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		// TODO: it should be an parameter application
		env.put(Context.PROVIDER_URL, ldapUrl);

		env.put(Context.SECURITY_AUTHENTICATION, "simple");
		env.put(Context.SECURITY_PRINCIPAL, "uid=" + username + ",ou=Users,dc=lab,dc=dextra,dc=com,dc=br");
		env.put(Context.SECURITY_CREDENTIALS, password);

		try {
			DirContext ctx = new InitialDirContext(env);
			AuthenticationData authenticationData = new AuthenticationData(username, DEFAULT_PROVIDER);
			return authenticationData;
		} catch (NamingException e) {
			throw new AuthenticationFailedException(true);
		}
	}

}