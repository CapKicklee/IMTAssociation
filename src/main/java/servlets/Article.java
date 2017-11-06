package servlets;

import java.io.IOException;
import java.util.Map;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.dao.AdherentDAO;
import db.dao.ArticleDAO;
import db.mapper.BeanDaoMapper;
import db.bean.ArticleBean;
import db.mapper.Mappable;
import db.services.persistence.JPAPersistence;
import db.services.persistence.AdherentJPAPersistence;
import db.services.persistence.ArticleJPAPersistence;

/**
 * Servlet implementation class Commande
 */
@WebServlet({ "/article", "/article/*" })
public class Article extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private JPAPersistence<ArticleDAO, String> articleJPA = new ArticleJPAPersistence();
	private JPAPersistence<AdherentDAO, String> adherentJPA = new AdherentJPAPersistence();

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
		Map<ArticleBean, Integer> panier = (Map<ArticleBean, Integer>) request.getSession().getAttribute("panier");
		System.out.println(panier.isEmpty());
		Optional<Mappable> map = BeanDaoMapper.mapDAOToBean(articleJPA.load(request.getRequestURI().substring(request.getRequestURI().lastIndexOf('/')+1)))
				.getMapped();
		ArticleBean article = null;
		if (map.isPresent()) {
			article = (ArticleBean) map.get();
			System.out.println(article.getCode());
			if (panier.containsKey(article)) {
				panier.put(article, panier.get(article) + 1);
			} else {
				panier.put(article, 1);
			}
		}
		request.getSession().setAttribute("panier", panier);
		response.sendRedirect("/imt.association/accueil");
	}

}
