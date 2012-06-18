package br.com.dextra.common.security.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.dextra.security.AuthenticationFilter;

public class LogoutServlet extends HttpServlet {

	private static final long serialVersionUID = -29255177735331436L;

	public void destroy() {
		super.destroy();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();

		AuthenticationFilter.expireCookies(request, response);
		new LoginResponseHandler().sendResponse(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		HttpSession session = request.getSession();
		session.invalidate();

		AuthenticationFilter.expireCookies(request, response);
		new LoginResponseHandler().sendResponse(request, response);

	}

}
