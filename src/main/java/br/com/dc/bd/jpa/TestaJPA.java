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

		Repositorio repositorio = new Repositorio(manager, Contato.class);

		manager.getTransaction().begin();

		Long id = 1L;
		Usuario usuario = new Usuario();
		usuario.setId(id);
		Contato contato = new Contato();
		contato.setId(id);
		repositorio.remove(usuario);

		manager.getTransaction().commit();
		manager.close();

	}
}
