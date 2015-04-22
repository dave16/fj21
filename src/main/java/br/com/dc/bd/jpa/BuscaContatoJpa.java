package br.com.dc.bd.jpa;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.dc.models.Contato;

public class BuscaContatoJpa implements Logica {

	public void executa(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		String idEmTexto = request.getParameter("id");
		Long id = Long.parseLong(idEmTexto);
		
		EntityManager manager = EntityManagerUtil.getEntityManager();
		Repositorio repositorio = new Repositorio(manager, Contato.class);
		
		
		Contato contato = (Contato) repositorio.busca(id);
		
		request.setAttribute("buscaContato", contato);
		RequestDispatcher rd = request.getRequestDispatcher("/pagina-jpa/editar.jsp");
		rd.forward(request, response);
		
		System.out.println("Contato encontrado : " + contato.getNome() ) ;
		
		
	}

}
