package db.services.persistence;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import db.dao.ArticleDAO;
import db.services.jpa.JPAService;
import db.services.jpa.JPAOperation;

/**
 * JPA implementation for basic persistence operations ( entity "AdherentBean" )
 * 
 *
 */
public class ArticleJPAPersistence extends JPAService<ArticleDAO, String> implements JPAPersistence<ArticleDAO, String> {

	/**
	 * Constructor
	 */
	public ArticleJPAPersistence() {
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
		JPAOperation operation = new JPAOperation() {
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
