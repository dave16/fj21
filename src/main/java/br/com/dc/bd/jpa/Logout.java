package br.com.dc.bd.jpa;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Logout  implements Logica{

	public void executa(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.getSession().invalidate();
		
		response.sendRedirect("login.jsp");
	}


}
