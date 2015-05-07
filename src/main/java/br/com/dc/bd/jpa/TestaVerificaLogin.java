package br.com.dc.bd.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.dc.models.Contato;
import br.com.dc.models.Usuario;

public class TestaVerificaLogin {

	public static void main(String [] args){
		
		EntityManager manager = new EntityManagerUtil().getEntityManager();
		
		Repositorio repositorio = new Repositorio(manager, Contato.class);
		
		manager.getTransaction().begin();
		
		String login = "nelson";
		String senha = "12345";
		
		
		
		List lista  =  repositorio.verificaLog(login, senha);
		
		
		
		manager.getTransaction().commit();
		
		
	}
}
