package br.com.dc.bd.jpa;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

import org.hibernate.jpa.criteria.predicate.IsEmptyPredicate;

import br.com.dc.models.Contato;
import br.com.dc.models.Usuario;

public class Repositorio<T> {

	private EntityManager manager;
	private Class<T> t;

	public Repositorio(EntityManager manager, Class<T> t) {
		this.manager = manager;
		this.t = t;
	}

	public void adiciona(T t) {
		manager.persist(t);
	}

	public T busca(Long id) {
		T classe = manager.find(t, id);
		return classe;
		// return manager.find(t,id);
	}

	public List<T> getListaTudo() {
		Query query = manager.createQuery("select c from Contato c");
		return query.getResultList();
	}

	public void remove(T entidade) {
		manager.remove(manager.merge(entidade));
	}

	public void atualiza(T entidade, Long id) {
		entidade = manager.find(t, id);
		manager.merge(entidade);
		System.out.println("Fim do método atualiza");
	}

	public T verificaLogin(String login, String senha) {
		String sql = "select c from Usuario c where login = :login and senha = :senha";
		Query query = manager.createQuery(sql);
		query.setParameter("login", login);
		query.setParameter("senha", senha);
		T t = (T) query.getSingleResult();
		if (query.getSingleResult() == null) {
			System.out.println("Não Encontrado");

		} else {
			System.out.println("Encontrado");

		}
		return (T) query.getSingleResult();
	}

	public List verificaLog(String login, String senha) {
		List lista = null;
		String sql = "select c from Usuario c where login = :login and senha = :senha";
		Query query = manager.createQuery(sql);
		query.setParameter("login", login);
		query.setParameter("senha", senha);
		try {
			lista = query.getResultList();
			return lista;
		} catch (NoResultException e) {
			e.printStackTrace();
			return null;

		}
	}
	
}
