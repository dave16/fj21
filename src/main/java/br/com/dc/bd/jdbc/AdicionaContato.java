package br.com.dc.bd.jdbc;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.dc.models.Contato;
import br.com.dc.models.Usuario;

public class AdicionaContato implements Logica {

	public void executa(HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String endereco = request.getParameter("endereco");
		String dataEmTexto = request.getParameter("dataNascimento");
		Calendar dataCadastro = Calendar.getInstance();
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");

		Calendar dataNascimento = converteDataParaCalendar(dataEmTexto);

		Usuario usuario = new Usuario();
		usuario.setLogin(login);
		usuario.setSenha(senha);

		ContatoDAO dao = new ContatoDAO();
		dao.adicionaUsuario(usuario);

		Contato contato = new Contato();
		contato.setNome(nome);
		contato.setEmail(email);
		contato.setEndereco(endereco);
		contato.setDataNascimento(dataNascimento);
		contato.setDataCadastro(dataCadastro);
		contato.setUsuario(usuario);
		dao.adiciona(contato);

		System.out.println("Contato " + nome + "adicionado");

		RequestDispatcher rd = request
				.getRequestDispatcher("/contato-adicionado.jsp");
		rd.forward(request, response);
	}

	public Calendar converteDataParaCalendar(String data) {
		Calendar dataNascimento = Calendar.getInstance();
		try {
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(data);
			dataNascimento.setTime(date);
		} catch (ParseException e) {
			System.out.println("Erro na conversão da data");
		}
		return dataNascimento;
	}

}
