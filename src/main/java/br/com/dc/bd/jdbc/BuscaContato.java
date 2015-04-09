package br.com.dc.bd.jdbc;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.dc.models.Contato;

public class BuscaContato implements Logica{

	public void executa(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		String param = request.getParameter("id");
		long id = Long.parseLong(param);
		
		int i = (int) id;
		
		Contato contato = new Contato();
		contato.setId(id);
		
		ContatoDAO dao = new ContatoDAO();
		contato =  dao.buscaContato(contato);
		
		System.out.println(contato.getId());
		System.out.println(contato.getNome());
		System.out.println(contato.getEmail());
		System.out.println(contato.getEndereco());
		System.out.println(contato.getDataNascimento());
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String data = sdf.format(contato.getDataNascimento().getTime());
		System.out.println(data);
		
		request.setAttribute("cont", contato);
		
		RequestDispatcher rd = request.getRequestDispatcher("altera-contato.jsp");
		rd.forward(request, response);
		
	}

	
	
	
}
