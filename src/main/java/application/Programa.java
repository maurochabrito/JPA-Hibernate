package application;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa"); 
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Pessoa p = em.find(Pessoa.class, 1);
		em.getTransaction().commit();
		System.out.println("Done!\n\n"+p);
		em.close();
		emf.close();
	}

}
