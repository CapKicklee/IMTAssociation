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

import db.bean.Adherent;
import db.bean.Adresse;
import db.bean.Pays;
import db.dao.PaysDAO;
import db.mapper.BeanDaoMapper;
import db.mapper.Mappable;
import db.mapper.MapperResult;
/*import database.services.AdherentPersistenceJPA;
import database.services.AdressePersistenceJPA;
import database.services.PaysPersistenceJPA;
import database.services.interfaces.AdherentPersistence;
import database.services.interfaces.AdressePersistence;
import database.services.interfaces.PaysPersistence;*/

/**
 * Servlet implementation class Login
 */
@WebServlet({"/login", "/login/*"})
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/*private AdherentPersistence adherentJPA = new AdherentPersistenceJPA();
	private AdressePersistence adresseJPA = new AdressePersistenceJPA();
	private PaysPersistence paysJPA = new PaysPersistenceJPA();*/
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*if (request.getRequestURI().contains("auth")) {
			Adherent adherent = authenticate(request);
			if (adherent != null) {
				request.getSession().setAttribute("user", adherent); // Put user in session.
			} else {
				
			}
		} else if (request.getRequestURI().contains("create")) {
			create(request);
		}*/
		process(request, response);
	}
	
	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Pays> pays = new ArrayList<>();
		/*for (PaysDAO paysDAO : paysJPA.loadAll()) {
			//TODO mapper les pays
		}*/
		pays.add(new Pays("FR", "France"));
		request.getSession().setAttribute("paysListe", pays);
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/login.jsp");
		rd.forward(request, response);
	}
	
	/*private Adherent authenticate (HttpServletRequest request) {
		String login = request.getParameter("username");
		String password = request.getParameter("password");
		MapperResult map = BeanDaoMapper.mapDAOToBean(adherentJPA.load(login, password));
		Adherent adherent = null;
		
		if (map.getMapped().get() != null) {
		    return adherent;
		} else {
		    request.setAttribute("error", "Unknown login, try again"); // Set error msg for ${error}
		    request.getRequestDispatcher("/login.jsp").forward(request, response); // Go back to login page.
		}
		
		
		if (map.getMapped().isPresent()) {
			adherent = map.getMapped().get().getObjectValues();
		} else {
			for (MapperError error : map.getMapperErrors()) {
				System.err.println(error);
			}
		}
	}
	
	private boolean create (HttpServletRequest request) {
		String login = (String) request.getAttribute("login");
		if (adherentJPA.load(login)!= null) {
			return false;
		} else {
			String password = (String) request.getAttribute("password");
			String password2 = (String) request.getAttribute("password2");
			String nom = (String) request.getAttribute("nom");
			String prenom = (String) request.getAttribute("prenom");
			if (!password.equals(password2)) {
				return false;
			}
			Adresse adresse = null;
			String rue = (String) request.getAttribute("rue");
			if (!"".equals(rue)) {
				Integer cp = Integer.getInteger((String) request.getAttribute("cp"));
				String ville = (String) request.getAttribute("ville");
				Pays pays = (Pays) request.getAttribute("pays");
				Integer id = (int) (adresseJPA.countAll()) + 1;
				adresse = new Adresse(id, rue, cp, ville, pays);
				MapperResult res = BeanDaoMapper.mapBeanToDAO(adresse);
			}
			Adherent newAdh = new Adherent(login, password, nom, prenom, adresse);
			MapperResult adhRes = BeanDaoMapper.mapBeanToDAO(newAdh);
		}
	}*/

}
