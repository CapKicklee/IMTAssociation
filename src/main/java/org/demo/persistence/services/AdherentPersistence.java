/*
 * Created on 1 nov. 2017 ( Time 17:24:25 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.persistence.services;

import java.util.List;
import java.util.Map;

import org.demo.bean.jpa.AdherentEntity;

/**
 * Basic persistence operations for entity "Adherent"
 * 
 * This database.bean has a basic Primary Key : String
 *
 * @author Telosys Tools Generator
 *
 */
public interface AdherentPersistence {

	/**
	 * Deletes the given entity <br>
	 * Transactional operation ( begin transaction and commit )
	 * @param adherent
	 * @return true if found and deleted, false if not found
	 */
	public boolean delete(AdherentEntity adherent) ;

	/**
	 * Deletes the entity by its Primary Key <br>
	 * Transactional operation ( begin transaction and commit )
	 * @param login
	 * @return true if found and deleted, false if not found
	 */
	public boolean delete(String login) ;

	/**
	 * Inserts the given entity and commit <br>
	 * Transactional operation ( begin transaction and commit )
	 * @param adherent
	 */
	public void insert(AdherentEntity adherent) ;

	/**
	 * Loads the entity for the given Primary Key <br>
	 * @param login
	 * @return the entity loaded (or null if not found)
	 */
	public AdherentEntity load(String login) ;

	/**
	 * Loads ALL the entities (use with caution)
	 * @return
	 */
	public List<AdherentEntity> loadAll() ;

	/**
	 * Loads a list of entities using the given "named query" without parameter 
	 * @param queryName
	 * @return
	 */
	public List<AdherentEntity> loadByNamedQuery(String queryName) ;

	/**
	 * Loads a list of entities using the given "named query" with parameters 
	 * @param queryName
	 * @param queryParameters
	 * @return
	 */
	public List<AdherentEntity> loadByNamedQuery(String queryName, Map<String, Object> queryParameters) ;

	/**
	 * Saves (create or update) the given entity <br>
	 * Transactional operation ( begin transaction and commit )
	 * @param adherent
	 * @return
	 */
	public AdherentEntity save(AdherentEntity adherent) ;

	/**
	 * Search the entities matching the given search criteria
	 * @param criteria
	 * @return
	 */
	public List<AdherentEntity> search( Map<String, Object> criteria ) ;

	/**
	 * Count all the occurrences
	 * @return
	 */
	public long countAll();
	
}
