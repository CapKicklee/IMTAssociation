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
@WebServlet("/commande")
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
		// TODO Auto-generated method stub
		process(request, response);
	}
	
	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//En attendant :
		HashMap<Integer,ArticleBean> panier = new HashMap<Integer,ArticleBean>();
		request.setAttribute("panier", panier);
		request.setAttribute("taillePanier",((HashMap) request.getAttribute("panier")).size());
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/commande.jsp");
		rd.forward(request, response);
	}

}
