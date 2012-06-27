package br.com.dextra.common.security.login;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.dextra.security.configuration.ResponseHandler;

public class IndexResponseHandler implements ResponseHandler {

	@Override
	public void sendResponse(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.sendRedirect(request.getContextPath() + "/muuk.html");
	}

}
