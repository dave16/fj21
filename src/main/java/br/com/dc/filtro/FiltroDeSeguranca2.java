package br.com.dc.filtro;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.dc.models.Usuario;

public class FiltroDeSeguranca2 implements Filter{

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session  = req.getSession();
		List<Usuario> lista = (List<Usuario>) session.getAttribute("usuario");
		if(lista == null){
			session.setAttribute("msg", "Voce nao está logado");
			HttpServletResponse rep = (HttpServletResponse) response;
			rep.sendRedirect(req.getContextPath() + "/loginJpa.jsp");
		}else{
			chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
