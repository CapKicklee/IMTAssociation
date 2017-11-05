package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.dao.ArticleDAO;
import db.services.persistenceJPA.ArticlePersistenceJPA;

/**
 * Servlet implementation class Commande
 */
@WebServlet("/commande")
public class Commande extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

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
		 /* Récupération de la session depuis la requête */
        HttpSession session = request.getSession();
        
		ArticlePersistenceJPA jpa = new ArticlePersistenceJPA();
		List<ArticleDAO> liste = jpa.loadAll();
		session.setAttribute("ListeArticle", liste);
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/commande.jsp");
		rd.forward(request, response);
	}

}
