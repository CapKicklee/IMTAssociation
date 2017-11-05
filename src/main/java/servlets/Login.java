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

import db.bean.Adherent;
import db.bean.ArticleBean;
import db.bean.Adresse;
import db.bean.Pays;
import db.dao.AdherentDAO;
import db.dao.AdresseDAO;
import db.dao.PaysDAO;
import db.mapper.BeanDaoMapper;
import db.mapper.Mappable;
import db.mapper.MapperResult;
import db.services.interfaces.AdherentPersistence;
import db.services.interfaces.AdressePersistence;
import db.services.interfaces.PaysPersistence;
import db.services.persistenceJPA.AdherentPersistenceJPA;
import db.services.persistenceJPA.AdressePersistenceJPA;
import db.services.persistenceJPA.PaysPersistenceJPA;

/**
 * Servlet implementation class Login
 */
@WebServlet({ "/login", "/login/*" })
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AdherentPersistence adherentJPA = new AdherentPersistenceJPA();
	private AdressePersistence adresseJPA = new AdressePersistenceJPA();
	private PaysPersistence paysJPA = new PaysPersistenceJPA();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getSession().getAttribute("user") != null) {
			request.getSession().setAttribute("panier", new HashMap<ArticleBean, Integer>());
			response.sendRedirect("/imt.association/accueil");
		} else {
			process(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getRequestURI().contains("auth")) {
			String login = request.getParameter("login");
			AdherentDAO adhDAO = adherentJPA.load(login);
			if (adhDAO != null) {
				MapperResult res = BeanDaoMapper.mapDAOToBean(adhDAO);
				if (res.getMapped().isPresent()) {
					String password = request.getParameter("password");
					if (password.equals(((Adherent) (res.getMapped().get())).getMotDePasse())) {
						request.getSession().setAttribute("user", (Adherent) res.getMapped().get());
						request.getSession().setAttribute("panier", new HashMap<ArticleBean, Integer>());
						System.out.println("connected");
						response.sendRedirect("/imt.association/accueil");
					} else {
						System.out.println("wrong password");
					}
				} else {
					System.out.println("empty");
				}
			} else {
				response.sendRedirect("/imt.association/login");
			}
		} else if (request.getRequestURI().contains("create")) {
			create(request);
			response.sendRedirect("/imt.association/login");
		}

		// process(request, response);
	}

	private void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Pays> pays = new ArrayList<>();
		for (PaysDAO paysDAO : (List<PaysDAO>) paysJPA.loadAll()) {
			MapperResult res = BeanDaoMapper.mapDAOToBean(paysDAO);
			if (res.getMapped().isPresent()) {
				pays.add((Pays) res.getMapped().get());
			}
		}
		request.getSession().setAttribute("paysListe", pays);
		request.getSession().setAttribute("adherent", new Adherent());
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/login.jsp");
		rd.forward(request, response);
	}

	private boolean create(HttpServletRequest request) {
		String login = (String) request.getParameter("login");
		if (adherentJPA.load(login) != null) {
			System.out.println("user already existing");
			return false;
		} else {
			String password = request.getParameter("password");
			String password2 = request.getParameter("password2");
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			if (!password.equals(password2)) {
				System.out.println("different passwords");
				return false;
			}
			Adresse adresse = null;
			String rue = request.getParameter("rue");
			if (!"".equals(rue)) {
				Integer cp = Integer.getInteger(request.getParameter("cp"));
				String ville = request.getParameter("ville");
				Pays pays = (Pays) BeanDaoMapper.mapDAOToBean(paysJPA.load(request.getParameter("pays"))).getMapped()
						.get();
				Integer id = (int) (adresseJPA.countAll()) + 1;
				adresse = new Adresse(id, rue, cp, ville, pays);
				MapperResult res = BeanDaoMapper.mapBeanToDAO(adresse);
				if (res.getMapped().isPresent()) {
					adresseJPA.insert((AdresseDAO) res.getMapped().get());
					System.out.println("address created");
				} else {
					System.out.println("error while creating address");
					return false;
				}
			}
			Adherent newAdh = new Adherent(login, password, nom, prenom, adresse);
			MapperResult adhRes = BeanDaoMapper.mapBeanToDAO(newAdh);
			if (adhRes.getMapped().isPresent()) {
				adherentJPA.insert((AdherentDAO) adhRes.getMapped().get());
				System.out.println("user created");
			} else {
				System.out.println("error while creating user");
				return false;
			}
			return true;
		}
	}

}
