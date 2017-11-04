/*
 * Created on 1 nov. 2017 ( Time 17:24:25 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */

package db.services.persistenceJPA;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import db.dao.AdresseDAO;
import db.services.commons.GenericJpaService;
import db.services.commons.JpaOperation;
import db.services.interfaces.AdressePersistence;

/**
 * JPA implementation for basic persistence operations ( entity "Adresse" )
 * 
 * @author Telosys Tools Generator
 *
 */
public class AdressePersistenceJPA extends GenericJpaService<AdresseDAO, Integer> implements AdressePersistence {

	/**
	 * Constructor
	 */
	public AdressePersistenceJPA() {
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
		JpaOperation operation = new JpaOperation() {
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