package br.com.dc.bd.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtil {

	private static EntityManagerFactory factory;
	
	static{
		try{
			factory = Persistence.createEntityManagerFactory("JPA-pu");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static EntityManager getEntityManager (){
		EntityManager manager;
		return factory.createEntityManager();
	}
	
	public static void closeEntityManagerFactory(){
		factory.close();
	}
	
}
