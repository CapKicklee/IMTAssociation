package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Optional;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.mapper.BeanDaoMapper;
import db.mapper.Mappable;
import db.mapper.MapperResult;
import db.services.interfaces.AdherentPersistence;
import db.services.interfaces.ArticlePersistence;
import db.services.persistenceJPA.AdherentPersistenceJPA;
import db.services.persistenceJPA.ArticlePersistenceJPA;

/**
 * Servlet implementation class Commande
 */
@WebServlet({"/article", "/article/*"})
public class Article extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private ArticlePersistence articleJPA = new ArticlePersistenceJPA();
    private AdherentPersistence adherentJPA = new AdherentPersistenceJPA();

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        process(request,response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	Map<Article, Integer> panier = (Map<Article, Integer>) request.getSession().getAttribute("panier");
    	Optional<Mappable> map = BeanDaoMapper.mapDAOToBean(articleJPA.load((String) request.getAttribute("article"))).getMapped();
    	Article article = null;
    	if (map.isPresent()) {
    		article = (Article) map.get();
    		if (panier.containsKey(article)) {
    			panier.put(article, panier.get(article) + 1);
    		} else {
    			panier.put(article, 1);
    		}
    	}
    	process(request, response);
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	Map<Article, Integer> panier = (Map<Article, Integer>) request.getSession().getAttribute("panier");
    	Optional<Mappable> map = BeanDaoMapper.mapDAOToBean(articleJPA.load((String) request.getAttribute("article"))).getMapped();
    	Article article = null;
    	if (map.isPresent()) {
    		article = (Article) map.get();
    		if (panier.containsKey(article)) {
    			panier.put(article, panier.get(article) + 1);
    		} else {
    			panier.put(article, 1);
    		}
    	}
    	RequestDispatcher rd = request.getRequestDispatcher("accueil");
		rd.forward(request, response);
	}

}
