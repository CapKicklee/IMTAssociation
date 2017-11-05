package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.bean.ArticleBean;
import db.dao.ArticleDAO;
import db.mapper.BeanDaoMapper;
import db.mapper.Mappable;
import db.services.interfaces.ArticlePersistence;
import db.services.persistenceJPA.ArticlePersistenceJPA;

/**
 * Servlet implementation class Commande
 */
@WebServlet({"/commande", "/commande/*"})
public class Commande extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ArticlePersistence articleJPA = new ArticlePersistenceJPA();
       

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
		if (request.getRequestURI().contains("commande/plus")) {
			ArticleDAO article=(ArticleDAO) articleJPA.load(request.getRequestURI().substring(request.getRequestURI().lastIndexOf('/')));
			Article articlebean = (Article) BeanDaoMapper.mapDAOToBean(article).getMapped().get();
			HashMap<Article,Integer> panier = (HashMap<Article, Integer>) request.getAttribute("panier");
			panier.replace(articlebean, panier.get(articlebean) +1);
			request.setAttribute("panier", panier);
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/commande.jsp");
			rd.forward(request, response);
		}
		
		if (request.getRequestURI().contains("commande/minus")) {
			ArticleDAO article=(ArticleDAO) articleJPA.load(request.getRequestURI().substring(request.getRequestURI().lastIndexOf('/')));
			Article articlebean = (Article) BeanDaoMapper.mapDAOToBean(article).getMapped().get();
			HashMap<Article,Integer> panier = (HashMap<Article, Integer>) request.getAttribute("panier");
			panier.replace(articlebean, panier.get(articlebean) +1);
			request.setAttribute("panier", panier);
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/commande.jsp");
			rd.forward(request, response);
		}
		process(request, response);
	}
	
	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//En attendant :
		HashMap<ArticleBean,Integer> panier = new HashMap<ArticleBean,Integer>();
		panier.put(new ArticleBean("PU1", "Article venant du code", "", 45.30, 56, ""),52);
		panier.put(new ArticleBean("002", "Article venant du code 2", "", 20.0, 23, ""),1);
		
		request.setAttribute("panier", panier);
		request.setAttribute("taillePanier",((HashMap) request.getAttribute("panier")).size());
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/commande.jsp");
		rd.forward(request, response);
	}

}
