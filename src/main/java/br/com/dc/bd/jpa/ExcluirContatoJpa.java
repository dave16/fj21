package br.com.dc.bd.jpa;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.dc.models.Contato;

public class ExcluirContatoJpa  implements Logica{

	public void executa(HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		String idTexto = request.getParameter("id");
		Long id = Long.parseLong(idTexto);
		
		EntityManager manager = EntityManagerUtil.getEntityManager();
		Repositorio repositorio = new Repositorio(manager, Contato.class);
		
		manager.getTransaction().begin();
		
		Contato contato = (Contato) repositorio.busca(id);
		contato.setId(id);
		
		repositorio.remove(contato);
		
		manager.getTransaction().commit();
		
		response.sendRedirect(request.getContextPath() + "/pagina-jpa/listaServlet.jsp");
		
	}

}
