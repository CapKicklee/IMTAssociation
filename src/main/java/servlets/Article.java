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
import db.bean.ArticleBean;
import db.mapper.Mappable;
import db.mapper.MapperResult;
import db.services.interfaces.AdherentPersistence;
import db.services.interfaces.ArticlePersistence;
import db.services.persistenceJPA.AdherentPersistenceJPA;
import db.services.persistenceJPA.ArticlePersistenceJPA;

/**
 * Servlet implementation class Commande
 */
@WebServlet({ "/article", "/article/*" })
public class Article extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ArticlePersistence articleJPA = new ArticlePersistenceJPA();
	private AdherentPersistence adherentJPA = new AdherentPersistenceJPA();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	private void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(request.getAttribute("article"));
		Map<String, Integer> panier = (Map<String, Integer>) request.getSession().getAttribute("panier");
		System.out.println(panier.isEmpty());
		Optional<Mappable> map = BeanDaoMapper.mapDAOToBean(articleJPA.load(request.getRequestURI().substring(request.getRequestURI().lastIndexOf('/')+1)))
				.getMapped();
		ArticleBean article = null;
		if (map.isPresent()) {
			article = (ArticleBean) map.get();
			System.out.println(article.getCode());
			if (panier.containsKey(article.getCode())) {
				panier.put(article.getCode(), panier.get(article.getCode()) + 1);
			} else {
				panier.put(article.getCode(), 1);
			}
		}
		request.getSession().setAttribute("panier", panier);
		response.sendRedirect("/imt.association/accueil");
	}

}
