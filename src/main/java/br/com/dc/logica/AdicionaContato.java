package br.com.dc.logica;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.dc.bd.ContatoDAO;
import br.com.dc.models.Contato;

public class AdicionaContato implements Logica {

	public void executa(HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String endereco = request.getParameter("endereco");
		String dataEmTexto = request.getParameter("dataNascimento");

		Calendar dataNascimento = Calendar.getInstance();
		try {
			Date data = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
			dataNascimento = Calendar.getInstance();
			dataNascimento.setTime(data);
		} catch (ParseException e) {
			System.out.println("Erro na conversão da data");
		}

		Contato contato = new Contato();
		contato.setNome(nome);
		contato.setEmail(email);
		contato.setEndereco(endereco);
		contato.setDataNascimento(dataNascimento);

		ContatoDAO dao = new ContatoDAO();
		dao.adiciona(contato);

		System.out.println("Contato " + nome + "adicionado");
		
		RequestDispatcher rd = request.getRequestDispatcher("/contato-adicionado.jsp");
		rd.forward(request, response);
	}

}
