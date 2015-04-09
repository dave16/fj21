package br.com.dc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.dc.bd.jdbc.Logica;

public class ControllerServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 
		String parametro = request.getParameter("logica");
		String nomeDaClasse = "br.com.dc.bd.jdbc." + parametro;
		
		try{
			Class classe = Class.forName(nomeDaClasse);
			
			Logica logica = (Logica) classe.newInstance();
			logica.executa(request, response);
			
		}catch(Exception e){
			throw new ServletException("A logica de negócios causou uma exceção" + e);
		}
		
		
	}
}
