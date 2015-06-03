package br.com.dc.bd.jpa;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.dc.models.Contato;
import br.com.dc.models.Usuario;

public class AdicionaContatoJpa implements Logica {

	public void executa(HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String endereco = request.getParameter("endereco");
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		Calendar dataCadastro = Calendar.getInstance() ;
		String dataEmString = request.getParameter("dataNascimento");
		Calendar dataNascimento = dataFormatada(dataEmString);
		
		
		EntityManager manager = EntityManagerUtil.getEntityManager();	
		Repositorio repositorio = new Repositorio(manager , Contato.class);

		manager.getTransaction().begin();

		Usuario usuario = new Usuario();
		usuario.setLogin(login);
		usuario.setSenha(senha);
		
		Contato contato = new Contato();
		contato.setNome(nome);
		contato.setEmail(email);
		contato.setEndereco(endereco);
		contato.setDataCadastro(dataCadastro);
		contato.setDataNascimento(dataNascimento);
		contato.setUsuario(usuario);
		
		repositorio.adiciona(contato);

		manager.getTransaction().commit();
		
		System.out.println("Contato " + nome + "adicionado com sucesso");
		
		response.sendRedirect(request.getContextPath() + "/pagina-jpa/listaServlet.jsp");
		
	
	
	}

	public Calendar dataFormatada(String dataEmString) {
		Calendar data = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date date;
		try {
			date = sdf.parse(dataEmString);
			data.setTime(date);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

}
