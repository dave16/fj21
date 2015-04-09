package br.com.dc.bd.jdbc;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.dc.models.Contato;

public class ExcluirContato implements Logica {

	public void executa(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		String param = request.getParameter("id");
		long id = Long.parseLong(param);
		
		Contato contato = new Contato();
		contato.setId(id);
		
		ContatoDAO dao = new ContatoDAO();
		dao.remove(contato);
		
		System.out.println("Contato removido com sucesso");
		
		RequestDispatcher rd = request.getRequestDispatcher("/lista-contatos-elegante.jsp");
		rd.forward(request, response);
	}

}
