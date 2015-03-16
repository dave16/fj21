package br.com.dc.logica;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.dc.models.Contato;
 
public class Rascunho implements Logica{

	public void executa(HttpServletRequest request, HttpServletResponse response)
			throws Exception {


		Contato contato = new Contato();
		
		contato.setId(2L);
		contato.setNome("e");
		contato.setEmail("ere");
		
		Calendar hoje = Calendar.getInstance();
		SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		String e = data.format(hoje.getTime());
		System.out.println(e);
		
		request.setAttribute("contatos", contato);
		RequestDispatcher rd = request.getRequestDispatcher("rascunho.jsp");
		rd.forward(request, response);
	}

}
