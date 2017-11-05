/*
 * Created on 1 nov. 2017 ( Time 17:24:25 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */

package db.services.persistenceJPA;


import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import db.dao.AdherentDAO;
import db.services.commons.GenericJpaService;
import db.services.commons.JpaOperation;
import db.services.interfaces.AdherentPersistence;

/**
 * JPA implementation for basic persistence operations ( entity "AdherentBean" )
 * 
 * @author Telosys Tools Generator
 *
 */
public class AdherentPersistenceJPA extends GenericJpaService<AdherentDAO, String> implements AdherentPersistence {

	/**
	 * Constructor
	 */
	public AdherentPersistenceJPA() {
		super(AdherentDAO.class);
	}

	@Override
	public AdherentDAO load( String login ) {
		return super.load( login );
	}

	@Override
	public boolean delete( String login ) {
		return super.delete( login );
	}

	@Override
	public boolean delete(AdherentDAO entity) {
		if ( entity != null ) {
			return super.delete( entity.getLogin() );
		}
		return false ;
	}

	@Override
	public long countAll() {
		// JPA operation definition 
		JpaOperation operation = new JpaOperation() {
			@Override
			public Object exectue(EntityManager em) throws PersistenceException {
				Query query = em.createNamedQuery("AdherentDAO.countAll");
				return query.getSingleResult() ;
			}
		} ;
		// JPA operation execution 
		return (Long) execute(operation);
	}



}
