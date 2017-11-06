package db.persistence;

import db.services.persistence.*;
import db.services.persistence.AdherentJPAPersistence;
import db.services.persistence.AdresseJPAPersistence;
import org.hibernate.exception.JDBCConnectionException;
import org.hibernate.service.spi.ServiceException;

import javax.crypto.spec.OAEPParameterSpec;
import javax.persistence.PersistenceException;
import javax.swing.text.html.Option;
import java.util.Optional;

public class TestPersistence {

	public static void main(String[] args) {

	    String test = null;
        Optional<String> strOp = Optional.ofNullable(test);
        System.out.println("hey - " + strOp);

        /*AdherentJPAPersistence jpa = new AdherentJPAPersistence();
        try {
            System.out.println(jpa.loadAll().toString());
        } catch (JDBCConnectionException ex) {
            System.out.println("JDBCConnectionException");
        }catch (ServiceException ex) {
            System.out.println("ServiceException");
        }
        catch (PersistenceException ex) {
            System.out.println("PERSISTENCE_EXCEPTION");
        }

	    /*AdherentJPAPersistence jpa = new AdherentJPAPersistence();
		System.out.println(jpa.loadAll().toString());
		System.out.println(jpa.countAll());*/
		
		/*ArticleJPAPersistence jpa2 = new ArticleJPAPersistence();
		System.out.println(jpa2.loadAll().toString());
		System.out.println(jpa2.countAll());
		
		AdresseJPAPersistence jpa3 = new AdresseJPAPersistence();
		System.out.println(jpa3.loadAll().toString());
		System.out.println(jpa3.countAll());
		
		PaysJPAPersistence jpa4 = new PaysJPAPersistence();
		System.out.println(jpa4.loadAll().toString());
		System.out.println(jpa4.countAll());*/
	}

}
