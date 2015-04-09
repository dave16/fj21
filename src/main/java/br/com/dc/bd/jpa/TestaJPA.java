package br.com.dc.bd.jpa;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.dc.models.Contato;
import br.com.dc.models.Usuario;

public class TestaJPA {

	public static void main(String[] args) {

		EntityManager manager = EntityManagerUtil.getEntityManager();
		
		Repositorio repositorio = new Repositorio(manager , Contato.class);

		manager.getTransaction().begin();
		
		Long id = 4L;
	//	System.out.println(	repositorio.busca(id));
		Contato contato = new Contato();
	//	contato.setId(8L);
	//	repositorio.remove(contato);
		
		
	/*
		Usuario usuario = new Usuario();
		usuario.setLogin("eu");
		usuario.setSenha("123");

		Contato contatoAdiciona = new Contato();
		contatoAdiciona.setNome("Nelson");
		contatoAdiciona.setEmail("estebam@ig.com");
		contatoAdiciona.setEndereco("Rua");
		contatoAdiciona.setDataCadastro(Calendar.getInstance());
		contatoAdiciona.setDataNascimento(Calendar.getInstance());
		contatoAdiciona.setUsuario(usuario);

		repositorio.adiciona(usuario);
		repositorio.adiciona(contatoAdiciona);

		
	*/
		
		List<Contato> lista = new ArrayList<Contato>();
		lista = repositorio.getListaTudo();
		
		for(Contato contat : lista){
			System.out.println("Id : " + contat.getId());
			System.out.println("Nome : " + contat.getNome());
			System.out.println("Email : " + contat.getEmail());
			System.out.println("Endereco : " + contat.getEndereco());
			
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
			String dataFormatada = formato.format(contat.getDataCadastro().getTime());
			System.out.println("Data Cadastro : " + dataFormatada);
			
			System.out.println("Login : " + contat.getUsuario().getLogin());
			System.out.println("Senha :  " + contat.getUsuario().getSenha() + "\n");
		}
		
		
		
	
		manager.getTransaction().commit();
		manager.close();

	}
}
