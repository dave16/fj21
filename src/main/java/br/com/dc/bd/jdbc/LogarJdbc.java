package br.com.dc.bd.jdbc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.dc.models.Usuario;

public class LogarJdbc implements Logica {

	public void executa(HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		String login = request.getParameter("loginParam");
		String senha = request.getParameter("senhaParam");

		System.out.println("LogarJdbc");
		System.out.println(login);
		System.out.println(senha);

		Usuario usuario = new Usuario();
		usuario.setLogin(login);
		usuario.setSenha(senha);

		ContatoDAO dao = new ContatoDAO();
		boolean ok = dao.verificaLogin(usuario);
		if (ok) {
			response.sendRedirect(request.getContextPath()
					+ "/paginas-jdbc/lista-contatos-elegante.jsp");
		} else {
			response.sendRedirect(request.getContextPath() + "/loginJdbc.jsp");
		}
	}

}
