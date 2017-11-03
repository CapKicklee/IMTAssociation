package database.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import database.services.AdherentPersistenceJPA;

public class TestPersistence {

	public static void main(String[] args) {
		/*
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence-unit1");
		EntityManager em = emf.createEntityManager();
		System.out.println(em.isOpen());
		em.close();
		emf.close();*/
		
		AdherentPersistenceJPA jpa = new AdherentPersistenceJPA();
		System.out.println(jpa.countAll());
	}

}
