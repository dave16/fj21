package br.com.dc.bd.jpa;

import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.dc.models.Contato;
import br.com.dc.models.Usuario;

public class TestaJpa3 {

	public static void main(String[] args) {
		
		String login = "euuuuuuuuu";
		String senha = "123";
		
		Long id = 5L;
		String nome = "Euuuuu";
		String email = "eu@u.com";
		String endereco = "Rua";
		
		
		EntityManager manager = new EntityManagerUtil().getEntityManager();
		Repositorio repositorio = new Repositorio(manager, Contato.class);		
		
		manager.getTransaction().begin();
		
		Usuario usuario = (Usuario) repositorio.busca(id);
		usuario.setLogin(login);
		usuario.setSenha(senha);
		
		Contato c = (Contato) repositorio.busca(id);
		System.out.println(c.getNome());
		c.setNome(nome);
		c.setEmail(email);
		c.setEndereco(endereco);
		c.setDataCadastro(Calendar.getInstance());
		
		c.setUsuario(usuario);
		
		repositorio.atualiza(usuario, id);
		repositorio.atualiza(c, id);
		
		
		
	//	repositorio.atualiza(contato , id);
		
		manager.getTransaction().commit();
		
		System.out.println("Contato atualizado");
	}
}
