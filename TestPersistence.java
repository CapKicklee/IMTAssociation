package db.persistence;

import db.services.AdherentPersistenceJPA;
import db.services.AdressePersistenceJPA;
import db.services.ArticlePersistenceJPA;
import db.services.PaysPersistenceJPA;

public class TestPersistence {

	public static void main(String[] args) {
		
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
