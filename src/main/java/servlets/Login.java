package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.bean.AdherentBean;
import db.bean.AdresseBean;
import db.bean.ArticleBean;
import db.bean.PaysBean;
import db.dao.AdherentDAO;
import db.dao.AdresseDAO;
import db.dao.PaysDAO;
import db.mapper.BeanDaoMapper;
import db.mapper.MapperResult;
import db.services.persistence.JPAPersistence;
import db.services.persistence.AdherentJPAPersistence;
import db.services.persistence.AdresseJPAPersistence;
import db.services.persistence.PaysJPAPersistence;

/**
 * Servlet implementation class Login
 */
@WebServlet({ "/login", "/login/*" })
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private JPAPersistence<AdherentDAO, String> adherentJPA = new AdherentJPAPersistence();
	private JPAPersistence<AdresseDAO, Integer> adresseJPA = new AdresseJPAPersistence();
	private JPAPersistence<PaysDAO, String> paysJPA = new PaysJPAPersistence();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getSession().getAttribute("user") != null) {
			request.getSession().setAttribute("panier", new TreeMap<String, Integer>());
			response.sendRedirect("/imt.association/home");
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
					if (password.equals(((AdherentBean) (res.getMapped().get())).getMotDePasse())) {
						request.getSession().setAttribute("user", (AdherentBean) res.getMapped().get());
						request.getSession().setAttribute("panier", new TreeMap<String, Integer>());
						System.out.println("connected");
						response.sendRedirect("/imt.association/home");
					} else {
						System.out.println("wrong password");
						request.getSession().setAttribute("erreur", "Le nom d'utilisateur ou le mot de passe est erroné");
						response.sendRedirect("/imt.association/login");
					}
				} else {
					request.getSession().setAttribute("erreur", "Le nom d'utilisateur ou le mot de passe est erroné");
					response.sendRedirect("/imt.association/login");
				}
			} else {
				request.getSession().setAttribute("erreur", "Le nom d'utilisateur ou le mot de passe est erroné");
				response.sendRedirect("/imt.association/login");
			}
		} else if (request.getRequestURI().contains("create")) {
			if (create(request)) {
				response.sendRedirect("/imt.association/home");
			} else {
				response.sendRedirect("/imt.association/login");
			}
		}

		// process(request, response);
	}

	private void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<PaysBean> pays = new ArrayList<>();
		for (PaysDAO paysDAO : (List<PaysDAO>) paysJPA.loadAll()) {
			MapperResult res = BeanDaoMapper.mapDAOToBean(paysDAO);
			if (res.getMapped().isPresent()) {
				pays.add((PaysBean) res.getMapped().get());
			}
		}
		request.getSession().setAttribute("paysListe", pays);
		request.getSession().setAttribute("adherent", new AdherentBean());
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
			AdresseBean adresseBean = null;
			String rue = request.getParameter("rue");
			if (!"".equals(rue)) {
				Integer cp = Integer.getInteger(request.getParameter("cp"));
				String ville = request.getParameter("ville");
				PaysBean paysBean = (PaysBean) BeanDaoMapper
						.mapDAOToBean(paysJPA.load(request.getParameter("paysBean"))).getMapped().get();
				Integer id = (int) (adresseJPA.countAll()) + 1;
				adresseBean = new AdresseBean(id, rue, cp, ville, paysBean);
				MapperResult res = BeanDaoMapper.mapBeanToDAO(adresseBean);
				if (res.getMapped().isPresent()) {
					adresseJPA.insert((AdresseDAO) res.getMapped().get());
					System.out.println("address created");
				} else {
					System.out.println("error while creating address");
					return false;
				}
			}
			AdherentBean newAdh = new AdherentBean(login, password, nom, prenom, adresseBean);
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
