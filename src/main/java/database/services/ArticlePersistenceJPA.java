package database.services;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import database.dao.ArticleDAO;
import database.services.commons.GenericJpaService;
import database.services.commons.JpaOperation;
import database.services.interfaces.ArticlePersistence;

/**
 * JPA implementation for basic persistence operations ( entity "Adherent" )
 * 
 *
 */
public class ArticlePersistenceJPA  extends GenericJpaService<ArticleDAO, String> implements ArticlePersistence {

	/**
	 * Constructor
	 */
	public ArticlePersistenceJPA() {
		super(ArticleDAO.class);
	}

	@Override
	public ArticleDAO load( String login ) {
		return super.load( login );
	}

	@Override
	public boolean delete( String login ) {
		return super.delete( login );
	}

	@Override
	public boolean delete(ArticleDAO entity) {
		if ( entity != null ) {
			return super.delete( entity.getCode() );
		}
		return false ;
	}

	@Override
	public long countAll() {
		// JPA operation definition 
		JpaOperation operation = new JpaOperation() {
			@Override
			public Object exectue(EntityManager em) throws PersistenceException {
				Query query = em.createNamedQuery("ArticleDAO.countAll");
				return query.getSingleResult() ;
			}
		} ;
		// JPA operation execution 
		return (Long) execute(operation);
	}



}
