package br.com.dc.bd.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.dc.models.Contato;

public class ListaContatoJpa implements Logica {

	public void executa(HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		EntityManager manager = EntityManagerUtil.getEntityManager();

		Repositorio repositorio = new Repositorio(manager, Contato.class);
		
		List<Contato> lista = new ArrayList<Contato>();
		lista = repositorio.getListaTudo();
		
		request.setAttribute("listaRepositorio"	, lista);		
		RequestDispatcher rd = request.getRequestDispatcher("/pagina-jpa/lista-contato.jsp");
		rd.forward(request, response);

	}

}
