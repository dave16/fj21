package br.com.dc.filtro;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.dc.models.Usuarios;

public class FiltroDeSeguranca implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filtro) throws IOException, ServletException {
		HttpSession session = ((HttpServletRequest) request).getSession();
		Usuarios usuario = (Usuarios) session.getAttribute("usuario");

		if (usuario == null) {

			session.setAttribute("msg",	"Você não está logado no sistema!");

			((HttpServletResponse) response).sendRedirect("/Fj21/" + "login.jsp");

		} else {

			filtro.doFilter(request, response);

		}

	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
