/*
 * Created on 1 nov. 2017 ( Time 17:24:25 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */

package db.services.persistence;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import db.dao.AdresseDAO;
import db.services.jpa.JPAService;
import db.services.jpa.JPAOperation;

/**
 * JPA implementation for basic persistence operations ( entity "AdresseBean" )
 * 
 * @author Telosys Tools Generator
 *
 */
public class AdresseJPAPersistence extends JPAService<AdresseDAO, Integer> implements JPAPersistence<AdresseDAO, Integer> {

	/**
	 * Constructor
	 */
	public AdresseJPAPersistence() {
		super(AdresseDAO.class);
	}

	@Override
	public AdresseDAO load( Integer id ) {
		return super.load( id );
	}

	@Override
	public boolean delete( Integer id ) {
		return super.delete( id );
	}

	@Override
	public boolean delete(AdresseDAO entity) {
		if ( entity != null ) {
			return super.delete( entity.getId() );
		}
		return false ;
	}

	@Override
	public long countAll() {
		// JPA operation definition 
		JPAOperation operation = new JPAOperation() {
			@Override
			public Object exectue(EntityManager em) throws PersistenceException {
				Query query = em.createNamedQuery("AdresseDAO.countAll");
				return query.getSingleResult() ;
			}
		} ;
		// JPA operation execution 
		return (Long) execute(operation);
	}

}
