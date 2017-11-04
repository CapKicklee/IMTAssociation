
package db.services.interfaces;

import java.util.List;
import java.util.Map;

import db.dao.ArticleDAO;



/**
 * Basic persistence operations for entity "Article"
 * 
 * This database.bean has a basic Primary Key : String
 *
 *
 */
public interface ArticlePersistence {

	/**
	 * Deletes the given entity <br>
	 * Transactional operation ( begin transaction and commit )
	 * @param article
	 * @return true if found and deleted, false if not found
	 */
	public boolean delete(ArticleDAO article) ;

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
	 * @param article
	 */
	public void insert(ArticleDAO article) ;

	/**
	 * Loads the entity for the given Primary Key <br>
	 * @param login
	 * @return the entity loaded (or null if not found)
	 */
	public ArticleDAO load(String login) ;

	/**
	 * Loads ALL the entities (use with caution)
	 * @return
	 */
	public List<ArticleDAO> loadAll() ;



	/**
	 * Saves (create or update) the given entity <br>
	 * Transactional operation ( begin transaction and commit )
	 * @param article
	 * @return
	 */
	public ArticleDAO save(ArticleDAO article) ;



	/**
	 * Count all the occurrences
	 * @return
	 */
	public long countAll();
	
}
