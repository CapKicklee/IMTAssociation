package db.persistence;

import db.services.persistenceJPA.AdherentPersistenceJPA;
import db.services.persistenceJPA.AdressePersistenceJPA;
import db.services.persistenceJPA.ArticlePersistenceJPA;
import db.services.persistenceJPA.PaysPersistenceJPA;

public class TestPersistence {

	public static void main(String[] args) {


	    String str = (String) "hey";

		AdherentPersistenceJPA jpa = new AdherentPersistenceJPA();
		System.out.println(jpa.loadAll().toString());
		System.out.println(jpa.countAll());
		
		ArticlePersistenceJPA jpa2 = new ArticlePersistenceJPA();
		System.out.println(jpa2.loadAll().toString());
		System.out.println(jpa2.countAll());
		
		AdressePersistenceJPA jpa3 = new AdressePersistenceJPA();
		System.out.println(jpa3.loadAll().toString());
		System.out.println(jpa3.countAll());
		
		PaysPersistenceJPA jpa4 = new PaysPersistenceJPA();
		System.out.println(jpa4.loadAll().toString());
		System.out.println(jpa4.countAll());
	}

}
