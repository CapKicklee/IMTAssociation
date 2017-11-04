package db.manager;

import db.bean.Adresse;
import db.dao.AdherentDAO;
import db.dao.AdresseDAO;
import db.dao.ArticleDAO;
import db.dao.DAO;
import db.dao.PaysDAO;
import db.mapper.BeanDaoMapper;
import db.mapper.MapperResult;
import db.services.commons.GenericJpaService;
import db.services.interfaces.AdressePersistence;
import db.services.persistenceJPA.AdherentPersistenceJPA;
import db.services.persistenceJPA.AdressePersistenceJPA;
import db.services.persistenceJPA.ArticlePersistenceJPA;
import db.services.persistenceJPA.PaysPersistenceJPA;
import db.services.results.JPAResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Classe utilitaire donnant accès à la base de données.
 */
public class DataBaseManager {

	public static final AdherentPersistenceJPA jpaAdherent = new AdherentPersistenceJPA();
	public static final AdressePersistenceJPA jpaAdresse = new AdressePersistenceJPA();
	public static final ArticlePersistenceJPA jpaArticle = new ArticlePersistenceJPA();
	public static final PaysPersistenceJPA jpaPays = new PaysPersistenceJPA();


	//====================================================================
	//---------------------------ADHERENT---------------------------------
	//====================================================================

	public static DataBaseQueryResult loadAllAdherents() {

		// Requête de la base de données
		JPAResult jpaResult = (JPAResult) jpaAdherent.loadAll();
		Optional<Object> adherentDAOOp = jpaResult.getResult();

		// Enregistrement du résultat
		DataBaseQueryResult dataBaseQueryResult = new DataBaseQueryResult();
		dataBaseQueryResult.setJpaResult(jpaResult);

		// Si des erreurs sont recontrées au moment du requetage de la base de données
		// le mapping ne peux pas se faire
		if (adherentDAOOp.isPresent()) {
			List<MapperResult> beanAdherentList = new ArrayList();
			for (AdherentDAO aderent : (List<AdherentDAO>) adherentDAOOp.get()) {
				MapperResult mapperResult = BeanDaoMapper.mapDAOToBean(aderent);
				beanAdherentList.add(mapperResult);
				dataBaseQueryResult.setMapperResult(mapperResult);
			}
		}

		return dataBaseQueryResult;

	}

	public static DataBaseQueryResult deleteAdherent(AdherentDAO adherent){
		return null;
		
	}

	public static DataBaseQueryResult deleteAdherent(String login){
		return null;

	}

	public static DataBaseQueryResult insertAdherent(AdherentDAO adherent){
		return null;

	}

	public static DataBaseQueryResult loadAdherent(String login){
		return null;

	}

	public static DataBaseQueryResult saveAdherent(AdherentDAO adherent){
		return null;

	}

	public static DataBaseQueryResult countAllAdherent(){
		return null;

	}

	//====================================================================
	//---------------------------ADRESSE----------------------------------
	//====================================================================

	public static DataBaseQueryResult loadAllAdresses() {

		// Requête de la base de données
		JPAResult jpaResult = (JPAResult) jpaAdresse.loadAll();
		Optional<Object> adresseDAOOp = jpaResult.getResult();

		// Enregistrement du résultat
		DataBaseQueryResult dataBaseQueryResult = new DataBaseQueryResult();
		dataBaseQueryResult.setJpaResult(jpaResult);

		// Si des erreurs sont recontrées au moment du requetage de la base de données
		// le mapping ne peux pas se faire
		if (adresseDAOOp.isPresent()) {
			List<MapperResult> beanAdherentList = new ArrayList();
			for (AdresseDAO adresse : (List<AdresseDAO>) adresseDAOOp.get()) {
				MapperResult mapperResult = BeanDaoMapper.mapDAOToBean(adresse);
				beanAdherentList.add(mapperResult);
				dataBaseQueryResult.setMapperResult(mapperResult);
			}
		}

		return dataBaseQueryResult;

	}

	public static DataBaseQueryResult deleteAdresse(AdresseDAO adresse){
		return null;

	}

	public static DataBaseQueryResult deleteAdresse(Integer id){
		return null;

	}

	public static DataBaseQueryResult insertAdresse(AdresseDAO adresse){
		return null;

	}

	public static DataBaseQueryResult loadAdresse(Integer id){
		return null;

	}

	public static DataBaseQueryResult saveAdresse(AdresseDAO adresse){
		return null;

	}

	public static DataBaseQueryResult countAllAdresse(){
		return null;

	}

	//====================================================================
	//---------------------------ARTICLE----------------------------------
	//====================================================================

	public static DataBaseQueryResult loadAllArticle() {

		// Requête de la base de données
		JPAResult jpaResult = (JPAResult) jpaArticle.loadAll();
		Optional<Object> articleDAOOp = jpaResult.getResult();

		// Enregistrement du résultat
		DataBaseQueryResult dataBaseQueryResult = new DataBaseQueryResult();
		dataBaseQueryResult.setJpaResult(jpaResult);

		// Si des erreurs sont recontrées au moment du requetage de la base de données
		// le mapping ne peux pas se faire
		if (articleDAOOp.isPresent()) {
			List<MapperResult> beanArticleList = new ArrayList();
			for (ArticleDAO article : (List<ArticleDAO>) articleDAOOp.get()) {
				MapperResult mapperResult = BeanDaoMapper.mapDAOToBean(article);
				beanArticleList.add(mapperResult);
				dataBaseQueryResult.setMapperResult(mapperResult);
			}
		}

		return dataBaseQueryResult;

	}

	public static DataBaseQueryResult deleteArticle(ArticleDAO article){
		return null;

	}

	public static DataBaseQueryResult deleteArticle(String code){
		return null;

	}

	public static DataBaseQueryResult insertArticle(ArticleDAO article){
		return null;

	}

	public static DataBaseQueryResult loadArticle(String code){
		return null;

	}

	public static DataBaseQueryResult saveArticle(ArticleDAO article){
		return null;

	}

	public static DataBaseQueryResult countAllArticle(){
		return null;

	}

	//====================================================================
	//-----------------------------PAYS-----------------------------------
	//====================================================================

	public static DataBaseQueryResult loadAllPays() {

		// Requête de la base de données
		JPAResult jpaResult = (JPAResult) jpaPays.loadAll();
		Optional<Object> paysDAOOp = jpaResult.getResult();

		// Enregistrement du résultat
		DataBaseQueryResult dataBaseQueryResult = new DataBaseQueryResult();
		dataBaseQueryResult.setJpaResult(jpaResult);

		// Si des erreurs sont recontrées au moment du requetage de la base de données
		// le mapping ne peux pas se faire
		if (paysDAOOp.isPresent()) {
			List<MapperResult> beanPaysList = new ArrayList();
			for (PaysDAO pays : (List<PaysDAO>) paysDAOOp.get()) {
				MapperResult mapperResult = BeanDaoMapper.mapDAOToBean(pays);
				beanPaysList.add(mapperResult);
				dataBaseQueryResult.setMapperResult(mapperResult);
			}
		}

		return dataBaseQueryResult;

	}

	public static DataBaseQueryResult deletePays(PaysDAO pays){
		return null;

	}

	public static DataBaseQueryResult deletePays(String code){
		return null;

	}

	public static DataBaseQueryResult insertPays(PaysDAO pays){
		return null;

	}

	public static DataBaseQueryResult loadPays(String code){
		return null;

	}

	public static DataBaseQueryResult savePays(PaysDAO pays){
		return null;

	}

	public static DataBaseQueryResult countAllPays(){
		return null;

	}


	public static void tes(JPAResult jpaResult) {



	}

}
