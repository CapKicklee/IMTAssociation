package db.manager;

import db.bean.AdherentBean;
import db.bean.ArticleBean;
import db.bean.PaysBean;
import db.dao.AdherentDAO;
import db.dao.AdresseDAO;
import db.dao.ArticleDAO;
import db.dao.PaysDAO;
import db.mapper.BeanDaoMapper;
import db.mapper.Mappable;
import db.mapper.MapperResult;
import db.services.persistence.*;
import db.services.persistence.AdherentJPAPersistence;
import db.services.persistence.AdresseJPAPersistence;
import db.services.results.JPAResult;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Classe utilitaire donnant accès à la base de données.
 */
public class DataBaseManager {

	public static final AdherentJPAPersistence jpaAdherent = new AdherentJPAPersistence();
	public static final AdresseJPAPersistence jpaAdresse = new AdresseJPAPersistence();
	public static final ArticleJPAPersistence jpaArticle = new ArticleJPAPersistence();
	public static final PaysJPAPersistence jpaPays = new PaysJPAPersistence();


	//====================================================================
	//---------------------------ADHERENT---------------------------------
	//====================================================================

	/*public static DataBaseQueryResult loadAllAdherents() {

		// Requête de la base de données
		JPAResult jpaResult = jpaAdherent.loadAll();

		// Enregistrement du résultat
		DataBaseQueryResult dataBaseQueryResult = new DataBaseQueryResult();
		dataBaseQueryResult.setJpaResult(jpaResult);

		// Si des erreurs sont recontrées au moment du requetage de la base de données
		// le mapping ne peux pas se faire
        Optional<Object> adherentDAOOp = jpaResult.getResult();
		if (adherentDAOOp.isPresent()) {
			List<MapperResult> beanAdherentList = new ArrayList();
			for (AdherentDAO adherent : (List<AdherentDAO>) adherentDAOOp.get()) {
				MapperResult mapperResult = BeanDaoMapper.mapDAOToBean(adherent);
				beanAdherentList.add(mapperResult);
			}
            //dataBaseQueryResult.setMapperResult(beanAdherentList);
		}
		return dataBaseQueryResult;

	}*/

	public static DataBaseQueryResult deleteAdherent(AdherentDAO adherent){
		return null;
		
	}

	public static DataBaseQueryResult deleteAdherent(String login){
		return null;

	}

	public static void insertAdherent(AdherentDAO adherent, HttpServletResponse response) throws IOException {
        JPAResult<Object> res = jpaAdherent.insert(adherent);
        if(!res.getResult().isPresent()) {
            response.sendRedirect("/imt.association/erreurDB");
        }
	}

    public static void insertAdresse(AdresseDAO adresseDAO, HttpServletResponse response) throws IOException {
        JPAResult<Object> res = jpaAdresse.insert(adresseDAO);
        if(!res.getResult().isPresent()) {
            response.sendRedirect("/imt.association/erreurDB");
        }
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

	/*public static DataBaseQueryResult loadAllAdresses() {

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

	}*/

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

    /**
     *
     * @param response
     * @throws IOException problème de redirection
     */
    public static Optional<List<ArticleBean>> loadAllArticles(HttpServletResponse response) throws IOException {
        List<ArticleBean> articles = null;
        JPAResult<List<ArticleDAO>> jpaRes = jpaArticle.loadAll();
        if(jpaRes.hasErrors()) {
            response.sendRedirect("/imt.association/erreurDB");
        } else if (jpaRes.getResult().isPresent()) {
            articles = new ArrayList<>();
            for (ArticleDAO dao : jpaRes.getResult().get()) {
                MapperResult mapRes = BeanDaoMapper.mapDAOToBean(dao);
                Optional<Mappable> map = mapRes.getMapped();
                if(mapRes.hasErrors()) {
                    response.sendRedirect("/imt.association/erreurDB");
                } else if (map.isPresent()) {
                    articles.add((ArticleBean) map.get());
                }
            }
        }
        return Optional.ofNullable(articles);
    }

    public static Optional<List<PaysBean>> loadAllPays(HttpServletResponse response) throws IOException {
        List<PaysBean> paysBeans = null;
        JPAResult<List<PaysDAO>> jpaRes = jpaPays.loadAll();
        if(jpaRes.hasErrors()) {
            response.sendRedirect("/imt.association/erreurDB");
        } else if (jpaRes.getResult().isPresent()) {
            paysBeans = new ArrayList<>();
            for (PaysDAO dao : jpaRes.getResult().get()) {
                MapperResult mapRes = BeanDaoMapper.mapDAOToBean(dao);
                Optional<Mappable> map = mapRes.getMapped();
                if(mapRes.hasErrors()) {
                    response.sendRedirect("/imt.association/erreurDB");
                } else if (map.isPresent()) {
                    paysBeans.add((PaysBean) map.get());
                }
            }
        }
        return Optional.ofNullable(paysBeans);
    }

    public static Optional<Long> callAllArticles(HttpServletResponse response) throws IOException {
        JPAResult<Long> jpaResCount = jpaArticle.countAll();
        return callAll(response, jpaResCount);
    }

    public static Optional<Long> callAllAdresse(HttpServletResponse response) throws IOException {
        JPAResult<Long> jpaResCount = jpaAdresse.countAll();
        return callAll(response, jpaResCount);
    }

    public static Optional<Long> callAllPays(HttpServletResponse response) throws IOException {
        JPAResult<Long> jpaResCount = jpaPays.countAll();
        return callAll(response, jpaResCount);
    }

    public static Optional<Long> callAllAdherent(HttpServletResponse response) throws IOException {
        JPAResult<Long> jpaResCount = jpaAdherent.countAll();
        return callAll(response, jpaResCount);
    }

    private static Optional<Long> callAll(HttpServletResponse response, JPAResult<Long> jpaResCount) throws IOException {
        if(jpaResCount.hasErrors()) {
            response.sendRedirect("/imt.association/erreurDB");
        } else {
            return Optional.ofNullable(jpaResCount.getResult().get());
        }
        return Optional.empty();
    }

	/*public static DataBaseQueryResult loadAllArticle() {

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

	}*/

	public static DataBaseQueryResult deleteArticle(ArticleDAO article){
		return null;

	}

	public static DataBaseQueryResult deleteArticle(String code){
		return null;

	}

	public static DataBaseQueryResult insertArticle(ArticleDAO article){
		return null;

	}

	public static Optional<ArticleBean> loadArticle(String code, HttpServletResponse response) throws IOException {

        JPAResult<ArticleDAO> jpaResultat = jpaArticle.load(code);

        Optional<ArticleBean> articlebean = Optional.empty();

        ArticleDAO article;
        if(jpaResultat.hasErrors()) {
            response.sendRedirect("/imt.association/erreurDB");
        } else {
            if (jpaResultat.getResult().isPresent()) {
                article = jpaResultat.getResult().get();
                MapperResult resMap = BeanDaoMapper.mapDAOToBean(article);
                if (resMap.hasErrors()) {
                    response.sendRedirect("/imt.association/erreurDB");
                } else {
                    articlebean = Optional.ofNullable((ArticleBean) resMap.getMapped().get());
                }
            }
        }
		return articlebean;

	}

    public static Optional<AdherentBean> loadAdherent(String login, HttpServletResponse response) throws IOException {

        JPAResult<AdherentDAO> jpaResultat = jpaAdherent.load(login);

        Optional<AdherentBean> adherentBean = Optional.empty();

        AdherentDAO adherentDAO;
        if(jpaResultat.hasErrors()) {
            response.sendRedirect("/imt.association/erreurDB");
        } else {
            if (jpaResultat.getResult().isPresent()) {
                adherentDAO = jpaResultat.getResult().get();
                MapperResult resMap = BeanDaoMapper.mapDAOToBean(adherentDAO);
                if (resMap.hasErrors()) {
                    response.sendRedirect("/imt.association/erreurDB");
                } else {
                    adherentBean = Optional.ofNullable((AdherentBean) resMap.getMapped().get());
                }
            }
        }
        return adherentBean;

    }

    public static Optional<PaysBean> loadPays(String login, HttpServletResponse response) throws IOException {

        JPAResult<PaysDAO> jpaResultat = jpaPays.load(login);

        Optional<PaysBean> paysBean = Optional.empty();

        PaysDAO paysDAO;
        if(jpaResultat.hasErrors()) {
            response.sendRedirect("/imt.association/erreurDB");
        } else {
            if (jpaResultat.getResult().isPresent()) {
                paysDAO = jpaResultat.getResult().get();
                MapperResult resMap = BeanDaoMapper.mapDAOToBean(paysDAO);
                if (resMap.hasErrors()) {
                    response.sendRedirect("/imt.association/erreurDB");
                } else {
                    paysBean = Optional.ofNullable((PaysBean) resMap.getMapped().get());
                }
            }
        }
        return paysBean;

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

	/*public static DataBaseQueryResult loadAllPays() {

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

	}*/

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



}
