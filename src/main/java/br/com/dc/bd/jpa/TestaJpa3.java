package br.com.dc.bd.jpa;

import javax.persistence.EntityManager;

import br.com.dc.models.Contato;

public class TestaJpa3 {

	public static void main(String[] args) {
		
		EntityManager manager = EntityManagerUtil.getEntityManager();
		Repositorio repositorio = new Repositorio(manager, Contato.class);
		manager.getTransaction().begin();
		
		Contato contato = new Contato();
		contato.setId(2L);
		
		repositorio.remove(contato);
		
		manager.getTransaction().commit();
	}
}
