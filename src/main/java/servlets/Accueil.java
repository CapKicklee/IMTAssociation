package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.dao.ArticleDAO;
import db.bean.ArticleBean;
import db.mapper.BeanDaoMapper;
import db.mapper.Mappable;
import db.services.interfaces.AdressePersistence;
import db.services.interfaces.ArticlePersistence;
import db.services.persistenceJPA.AdressePersistenceJPA;
import db.services.persistenceJPA.ArticlePersistenceJPA;

/**
 * Servlet implementation class Accueil
 */
@WebServlet({"/accueil", "/accueil/*"})
public class Accueil extends HttpServlet {
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
		if (request.getRequestURI().contains("accueil/article")) {
			request.setAttribute("article", request.getRequestURI().substring(request.getRequestURI().lastIndexOf('/')+1));
			response.sendRedirect("/imt.association/article/" + request.getRequestURI().substring(request.getRequestURI().lastIndexOf('/')+1));
		} else {
			process(request, response);
		}
	}
	
	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<ArticleBean> articles = new ArrayList<>();
		for (ArticleDAO dao : articleJPA.loadAll()) {
			Optional<Mappable> map = BeanDaoMapper.mapDAOToBean(dao).getMapped();
			if (map.isPresent()) {
				articles.add((ArticleBean) map.get()); 
			}
		}
		request.setAttribute("articles", articles);
		request.setAttribute("taille", (int) articleJPA.countAll()); 
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/articles.jsp");
		rd.forward(request, response);
	}

}
