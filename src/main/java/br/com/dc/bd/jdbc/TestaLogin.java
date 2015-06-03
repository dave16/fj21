package br.com.dc.bd.jdbc;

import java.sql.SQLException;

import br.com.dc.models.Usuario;

public class TestaLogin {

	public static void main(String[] args) throws SQLException {

		ContatoDAO dao = new ContatoDAO();
		
		Usuario usuario = new Usuario();
		usuario.setLogin("estebam");
		usuario.setSenha("1234");
		
		boolean ok = dao.verificaLogin(usuario);
		
		if (ok) {
			System.out.println("yes");
		} else {
			System.out.println("falso");
		}
	}
}
