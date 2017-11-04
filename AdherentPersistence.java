/*
 * Created on 1 nov. 2017 ( Time 17:24:25 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package db.services.interfaces;

import java.util.List;
import java.util.Map;

import db.dao.AdherentDAO;



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
	public boolean delete(AdherentDAO adherent) ;

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
	public void insert(AdherentDAO adherent) ;

	/**
	 * Loads the entity for the given Primary Key <br>
	 * @param login
	 * @return the entity loaded (or null if not found)
	 */
	public AdherentDAO load(String login) ;

	/**
	 * Loads ALL the entities (use with caution)
	 * @return
	 */
	public List<AdherentDAO> loadAll() ;



	/**
	 * Saves (create or update) the given entity <br>
	 * Transactional operation ( begin transaction and commit )
	 * @param adherent
	 * @return
	 */
	public AdherentDAO save(AdherentDAO adherent) ;



	/**
	 * Count all the occurrences
	 * @return
	 */
	public long countAll();
	
}
