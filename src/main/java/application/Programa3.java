package application;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa3 {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa"); 
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		try {
			Pessoa p = em.find(Pessoa.class, 3);
			em.remove(p);
			System.out.println("Done! Person removed!\n\n"+p);
		}
		catch(java.lang.IllegalArgumentException e) {
			System.out.println("\"Attempt to creat delete event with null entity.\""
					+ "\nExplaination: you're attempting to delete a person from a inexistent id!");
		}
		em.getTransaction().commit();
		em.close();
		emf.close();
	}

}
