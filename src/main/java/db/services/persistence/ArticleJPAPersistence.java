package db.services.persistence;


import db.dao.ArticleDAO;
import db.services.jpa.JPAService;
import db.services.jpa.JPAResult;

import java.util.Optional;

/**
 * JPA implementation for basic persistence operations ( entity "AdherentBean" )
 *
 * @author Inspired by Telosys Tools for JPA testing
 * @author Juliette FRETAY, Kendall FOREST, Chloé GUILBAUD
 */
public class ArticleJPAPersistence extends JPAService<ArticleDAO, String> implements JPAPersistence<ArticleDAO, String> {

	/**
	 * Constructor
	 */
	public ArticleJPAPersistence() {
		super(ArticleDAO.class);
	}

	@Override
	public JPAResult<ArticleDAO> load(String login ) {
		return super.load( login );
	}

	@Override
	public JPAResult<Boolean> delete( String login ) {
		return super.delete( login );
	}

	@Override
	public JPAResult<Boolean> delete(ArticleDAO entity) {
		if ( entity != null ) {
			return super.delete( entity.getCode() );
		}
        return new JPAResult<>(Optional.of(false));
	}

	@Override
	public JPAResult<Long> countAll() {
        return super.countAll("ArticleDAO.countAll", "countAll ArticleJPA");
	}



}
