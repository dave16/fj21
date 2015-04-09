package br.com.dc.bd.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.dc.models.Contato;

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
		return manager.find(t, id);

	}

	public List<T> getListaTudo() {
		Query query = manager.createQuery("select c from Contato c");
		return query.getResultList();
	}

	public void remove(T entidade) {
		manager.remove(manager.merge(entidade));
	}

	public void atualiza(T entidade) {
		manager.find(t, entidade);
		manager.merge(entidade);
	}

}
