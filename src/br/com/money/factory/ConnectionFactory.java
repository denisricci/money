package br.com.money.factory;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionFactory {
	
	@Inject
	private EntityManagerFactory factory;
	
	@Produces
	@ApplicationScoped
	public EntityManagerFactory getFactory(){
		System.out.println("Criou Factory");
		return Persistence.createEntityManagerFactory("teste-jpa");
	}	
	
	@Produces @RequestScoped
	public EntityManager criarEntityManager(){
		System.out.println("Abrindo conexao..");
		return factory.createEntityManager();
	}
		
	public void fechaEntityManager(@Disposes EntityManager em){
		System.out.println("Fechou conexao");
		em.close();
	}

}
