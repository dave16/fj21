package br.com.dc.logica;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.dc.bd.ContatoDAO;
import br.com.dc.models.Contato;

public class ListaContato implements Logica{

	//http://localhost:8080/Fj21/mvc?logica=ListaContato
	
	public void executa(HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ContatoDAO dao = new ContatoDAO();
		List<Contato> lista = dao.getLista();
		
		for(Contato contato : lista){
			System.out.println("Id : " + contato.getId());
			System.out.println("Nome : " + contato.getNome());
			System.out.println("Email : " + contato.getEmail());
			System.out.println("Endereco : " + contato.getEndereco());
			System.out.println("Data Nascimento : " + contato.getDataNascimento() + "/n");
			
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/lista-contatos-elegante.jsp");
		rd.forward(request, response);
	}

}
