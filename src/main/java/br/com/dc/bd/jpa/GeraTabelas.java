package br.com.dc.bd.jpa;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.dc.models.Contato;
import br.com.dc.models.Usuario;

public class GeraTabelas {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("JPA-pu");

		factory.close();
	}
}
