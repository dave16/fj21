package br.com.dc.bd.jpa;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.dc.models.Usuario;

public class LogarJpa extends HttpServlet {

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		System.out.println(login);
		System.out.println(senha);

		EntityManager manager = new EntityManagerUtil().getEntityManager();

		Repositorio repositorio = new Repositorio(manager, Usuario.class);

		manager.getTransaction().begin();

		List<Usuario> lista = repositorio.verificaLog(login, senha);
		for (Usuario u : lista) {
			System.out.println(u.getLogin());
		}

		if (lista.isEmpty()) {
			response.sendRedirect(request.getContextPath() + "/login.jsp");
			request.getSession().setAttribute("mensagem", "Login ou senha incorretos !");
		}

		else {
			request.getSession().setAttribute("usuario", lista);
			response.sendRedirect(request.getContextPath() + "/admin/index.jsp");
		}
		manager.getTransaction().commit();

		/*
		 * 
		 * if (usuario == null || !usuario.getSenha().equals(senha)) {
		 * 
		 * request.getSession().setAttribute("msg",
		 * "Login ou senha incorretos!");
		 * 
		 * response.sendRedirect(request.getContextPath() + "/login.jsp");
		 * 
		 * } else {
		 * 
		 * request.getSession().setAttribute("usuario", usuario);
		 * 
		 * response.sendRedirect("adiciona-contato.jsp");
		 * 
		 * }
		 */
	}
}
