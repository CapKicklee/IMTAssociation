/*
 * Created on 1 nov. 2017 ( Date ISO 2017-11-01 - Time 17:25:42 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package db.services.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

/**
 * JPA operation interface
 * Provided by Telosys Tools for JPA testing
 *
 */
public interface JPAOperation {

	/**
	 * Executes a JPA operation using the given EntityManager
	 * @param em the EntityManager to be used
	 * @return
	 * @throws PersistenceException
	 */
	public Object exectue(EntityManager em) throws PersistenceException;
	
}