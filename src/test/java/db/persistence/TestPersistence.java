package db.persistence;

import db.services.persistence.*;
import db.services.persistence.AdherentJPAPersistence;
import db.services.persistence.AdresseJPAPersistence;

public class TestPersistence {

	public static void main(String[] args) {


	    String str = (String) "hey";

		AdherentJPAPersistence jpa = new AdherentJPAPersistence();
		System.out.println(jpa.loadAll().toString());
		System.out.println(jpa.countAll());
		
		ArticleJPAPersistence jpa2 = new ArticleJPAPersistence();
		System.out.println(jpa2.loadAll().toString());
		System.out.println(jpa2.countAll());
		
		AdresseJPAPersistence jpa3 = new AdresseJPAPersistence();
		System.out.println(jpa3.loadAll().toString());
		System.out.println(jpa3.countAll());
		
		PaysJPAPersistence jpa4 = new PaysJPAPersistence();
		System.out.println(jpa4.loadAll().toString());
		System.out.println(jpa4.countAll());
	}

}
