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

public class AlteraContato implements Logica{

	public void executa(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Contato contato = new Contato() ;
		
		long id = Long.parseLong(request.getParameter("id"));
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
		
		
		contato.setId(id);
		contato.setNome(nome);
		contato.setEmail(email);
		contato.setEndereco(endereco);
		contato.setDataNascimento(dataNascimento);
		
		
		ContatoDAO dao = new ContatoDAO();
		dao.altera(contato);
		
		RequestDispatcher rd = request.getRequestDispatcher("/lista-contatos-elegante.jsp");
		rd.forward(request, response);
		System.out.println("Alterando contato ..." + contato.getNome());
		
	}

}
