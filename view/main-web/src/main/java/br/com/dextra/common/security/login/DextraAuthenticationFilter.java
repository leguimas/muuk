package br.com.dextra.common.security.login;

import br.com.dextra.security.AuthenticationFilter;

/**
 * Its just a dxSecurity bug. You have to create a class to get the correct classloader.
 */
public class DextraAuthenticationFilter extends AuthenticationFilter {

	@Override
	protected ClassLoader getClassLoaderForConfiguration() {
		return this.getClass().getClassLoader();
	}

}
