package br.com.dc.bd.jpa;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.dc.models.Contato;
import br.com.dc.models.Usuario;

public class EditarJpa implements Logica {

	public void executa(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		String idTexto = request.getParameter("id");
		Long id = Long.parseLong(idTexto);
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String endereco = request.getParameter("endereco");
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		Calendar dataCadastro = Calendar.getInstance();
		String dataEmString = request.getParameter("dataNascimento");
		//Calendar dataNascimento = dataFormatada(dataEmString);
	
		EntityManager manager = new EntityManagerUtil().getEntityManager();
		Repositorio repositorio = new Repositorio(manager, Contato.class);		
		
		Usuario usuario ;
		
		
		Contato contato = (Contato) repositorio.busca(id);
		contato.setNome(nome);
		contato.setEmail(email);
		contato.setEndereco(endereco);
		contato.setDataNascimento(Calendar.getInstance());
		contato.getUsuario().setLogin(login);
		contato.getUsuario().setSenha(senha);
		
		
		manager.getTransaction().begin();
		
		
		repositorio.atualiza(contato,id);
		
		manager.getTransaction().commit();
		
		System.out.println("Contato atualizado");
		
		RequestDispatcher rd = request.getRequestDispatcher("/pagina-jpa/teste.jsp");
		rd.forward(request, response);
		

	}

	public Calendar dataFormatada(String dataEmString) {
		Calendar data = Calendar.getInstance();
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
			data.setTime(sdf.parse(dataEmString));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

}
