package br.com.dc.bd;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import br.com.dc.models.Contato;
import br.com.dc.models.Usuario;

public class TestaDAO {

	public static void main(String[] args) throws ClassNotFoundException {

		Contato contato = new Contato();

		ContatoDAO dao = new ContatoDAO();

			
		List<Contato> lista = dao.getLista();

		for (Contato contatos : lista) {
			System.out.println("Id : " + contatos.getId());
			System.out.println("Nome : " + contatos.getNome());
			System.out.println("Email : " + contatos.getEmail());
			System.out.println("Endereco : " + contatos.getEndereco());
			System.out.println("Data Nascimento : "
					+ contatos.getDataNascimento().getTime());
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
			String e = formato.format(contatos.getDataNascimento().getTime());
			System.out.println(e + "\n");

		}
		
		Usuario usuario = new Usuario();
		usuario.setLogin("eu");
		usuario.setSenha("123");
		dao.adicionaUsuario(usuario);
		
	}
}
