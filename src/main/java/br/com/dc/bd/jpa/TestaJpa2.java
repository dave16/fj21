package br.com.dc.bd.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.dc.models.Contato;

public class TestaJpa2 {

	public static void main(String[] args) {

		EntityManager manager = EntityManagerUtil.getEntityManager();

		Repositorio repositorio = new Repositorio(manager, Contato.class);
		manager.getTransaction().begin();
		
		
		List<Contato> lista = new ArrayList<Contato>();
		lista = repositorio.getListaTudo();

		for (Contato contato : lista) {
			System.out.println("Id : " + contato.getId());
			System.out.println("Nome : " + contato.getNome());
			System.out.println("Email : " + contato.getEmail());
			System.out.println("Login : " + contato.getUsuario().getLogin());
			System.out.println("Senha : " + contato.getUsuario().getSenha()
					+ "\n");

		}
		
		manager.getTransaction().commit();
		manager.close();
		EntityManagerUtil.closeEntityManagerFactory();
	}
}
