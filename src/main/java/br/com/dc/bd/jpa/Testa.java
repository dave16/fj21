package br.com.dc.bd.jpa;

import javax.persistence.EntityManager;

import br.com.dc.models.Contato;
import br.com.dc.models.Customer;
import br.com.dc.models.User;

public class Testa {

	public static void main(String[] args) {

		EntityManager manager = new EntityManagerUtil().getEntityManager();

		try {
			manager.getTransaction().begin();
			
			Customer customer = new Customer();
			customer.setName("Sueo");
			
			
			User user = new User();
			user.setLogin("sueo");
			user.setPassword("123");

			customer.setUser(user);

			Repositorio repositorio = new Repositorio(manager, Customer.class);			
			repositorio.adiciona(customer);
			//manager.persist(customer);
			
			
			/*
			Customer customer = manager.find(Customer.class, 1);
			System.out.println(customer.getName());
			System.out.println(customer.getUser().getLogin());
			*/
			manager.getTransaction().commit();

		} catch (Exception e) {
			manager.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			manager.close();
		}
	}
}
