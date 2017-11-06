/*
 * Created on 1 nov. 2017 ( Time 17:25:42 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package db.services.persistence;

import java.util.List;

import db.dao.DAO;
import db.services.results.JPAResult;

/**
 * Basic persistence operations for entity "PaysBean"
 *
 * This database.bean has a basic Primary Key : String
 *
 * @author Telosys Tools Generator
 *
 */
public interface JPAPersistence<T extends DAO, G> {

    /**
     * Deletes the given entity <br>
     * Transactional operation ( begin transaction and commit )
     * @param pays
     * @return true if found and deleted, false if not found
     */
     JPAResult<Boolean> delete(T pays) ;

    /**
     * Deletes the entity by its Primary Key <br>
     * Transactional operation ( begin transaction and commit )
     * @param code - identifiant unique
     * @return true if found and deleted, false if not found
     */
    JPAResult<Boolean> delete(G code) ;

    /**
     * Inserts the given entity and commit <br>
     * Transactional operation ( begin transaction and commit )
     * @param pays
     */
    JPAResult insert(T pays) ;

    /**
     * Loads the entity for the given Primary Key <br>
     * @param code
     * @return the entity loaded (or null if not found)
     */
    JPAResult<T> load(G code) ;

    /**
     * Loads ALL the entities (use with caution)
     * @return
     */
    JPAResult<List<T>> loadAll() ;



    /**
     * Saves (create or update) the given entity <br>
     * Transactional operation ( begin transaction and commit )
     * @param pays
     * @return
     */
    JPAResult<T> save(T pays) ;



    /**
     * Count all the occurrences
     * @return
     */
    JPAResult<Long> countAll();

}
