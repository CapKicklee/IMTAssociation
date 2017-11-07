package servlets;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.TreeMap;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.bean.AdherentBean;
import db.bean.AdresseBean;
import db.bean.PaysBean;
import db.dao.AdherentDAO;
import db.dao.AdresseDAO;
import db.manager.DataBaseManager;
import db.mapper.BeanDaoMapper;
import db.mapper.MapperResult;

/**
 * Servlet de gestion de l'authentification et d'inscription
 *
 * @author Juliette FRETAY, Kendall FOREST, Chloé GUILBAUD
 */
@WebServlet({"/login", "/login/*"})
public class Login extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getSession().getAttribute("user") != null) {
        	request.getSession().removeAttribute("erreur");
            request.getSession().setAttribute("panier", new TreeMap<String, Integer>());
            response.sendRedirect("/imt.association/");
        } else {
        	//request.getSession().setAttribute("erreur", "Veuillez vous authentifier d'abord");
            process(request, response);
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getRequestURI().contains("auth")) {
            String login = request.getParameter("login");

            Optional<AdherentBean> adherentBeanOp = DataBaseManager.loadAdherent(login, response);

            if (adherentBeanOp.isPresent()) {
                AdherentBean adherentBean = adherentBeanOp.get();
                String password = request.getParameter("password");
                if (password.equals(adherentBean.getMotDePasse())) {
                    request.getSession().setAttribute("user", adherentBean);
                    request.getSession().setAttribute("panier", new TreeMap<String, Integer>());
                    System.out.println("connected");
                    //request.getSession().removeAttribute("erreur");
                    response.sendRedirect("/imt.association/");
                } else {
                    System.out.println("wrong password");
                    request.getSession().setAttribute("erreur", "Le nom d'utilisateur ou le mot de passe est erroné");
                    response.sendRedirect("/imt.association/login");
                }
            } else {
                request.getSession().setAttribute("erreur", "Le nom d'utilisateur ou le mot de passe est erroné");
                response.sendRedirect("/imt.association/login");
            }
        } else if (request.getRequestURI().contains("create")) {
            if (create(request, response)) {
            	//request.getSession().setAttribute("erreur", null);
                response.sendRedirect("/imt.association/");
            } else {
                response.sendRedirect("/imt.association/login");
            }
        } else {
        	response.sendRedirect("/imt.association/erreur404");
        }

    }

    private void process(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Optional<List<PaysBean>> paysList = DataBaseManager.loadAllPays(response);
        if (paysList.isPresent()) {
            request.getSession().setAttribute("paysListe", paysList.get());
            request.getSession().setAttribute("adherent", new AdherentBean());
            //request.getSession().removeAttribute("erreur");
            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/login.jsp");
            rd.forward(request, response);
        }

    }

    private boolean create(HttpServletRequest request, HttpServletResponse response) throws IOException {


        String login = (String) request.getParameter("login");

        Optional<AdherentBean> adherentOp = DataBaseManager.loadAdherent(login, response);

        if (adherentOp.isPresent()) {
        	request.setAttribute("erreur", "Ce nom d'utilisateur existe déjà");
            System.out.println("user already existing");
            return false;
        } else {
            String password = request.getParameter("password");
            String password2 = request.getParameter("password2");
            String nom = request.getParameter("nom");
            String prenom = request.getParameter("prenom");
            if (!password.equals(password2)) {
            	request.setAttribute("erreur", "Les mots de passe sont différents");
                System.out.println("different passwords");
                return false;
            }
            AdresseBean adresseBean = null;
            String rue = request.getParameter("rue");
            if (!"".equals(rue)) {

                Integer cp = Integer.getInteger(request.getParameter("cp"));
                String ville = request.getParameter("ville");

                Optional<PaysBean> paysBeanOp = DataBaseManager.loadPays(request.getParameter("paysBean"), response);

                if (paysBeanOp.isPresent()) {

                    PaysBean paysBean = paysBeanOp.get();

                    Optional<Long> idOp = DataBaseManager.countAllAdresse(response);

                    if (idOp.isPresent()) {

                        Integer id = ((int) (long) idOp.get()) + 1;

                        adresseBean = new AdresseBean(id, rue, cp, ville, paysBean);
                        MapperResult res = BeanDaoMapper.mapBeanToDAO(adresseBean);

                        if (res.getMapped().isPresent()) {
                            DataBaseManager.insertAdresse((AdresseDAO) res.getMapped().get(), response);
                        } else {
                        	request.setAttribute("erreur", "L'adresse n'a pas pu être créée, veuillez vérifier les informations");
                            return false;
                        }

                    }
                }
            }
            AdherentBean newAdh = new AdherentBean(login, password, nom, prenom, adresseBean);
            MapperResult adhRes = BeanDaoMapper.mapBeanToDAO(newAdh);
            if (adhRes.getMapped().isPresent()) {
                DataBaseManager.insertAdherent((AdherentDAO) adhRes.getMapped().get(), response);
                System.out.println("user created");
                request.setAttribute("succes", "Il n'y a plus d'articles à afficher, désolé...");
            } else {
            	request.setAttribute("erreur", "L'utilisateur n'a pas pu être créé, une erreur est survenue");
                return false;
            }
            return true;
        }
    }

}
