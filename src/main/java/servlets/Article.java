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
import db.manager.DataBaseManager;
import db.mapper.BeanDaoMapper;
import db.bean.ArticleBean;
import db.mapper.Mappable;
import db.services.persistence.JPAPersistence;
import db.services.persistence.AdherentJPAPersistence;
import db.services.persistence.ArticleJPAPersistence;

/**
 * Servlet implementation class Commande
 */
@WebServlet({"/article", "/article/*"})
public class Article extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        process(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        process(request, response);
    }

    private void process(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getSession().getAttribute("user") != null) {
            System.out.println(request.getAttribute("article"));
            request.getSession().removeAttribute("message");
            Map<String, Integer> panier = (Map<String, Integer>) request.getSession().getAttribute("panier");
            System.out.println(panier.isEmpty());

            String key = request.getRequestURI().substring(request.getRequestURI().lastIndexOf('/') + 1);
            Optional<ArticleBean> articleBeanOp = DataBaseManager.loadArticle(key, response);
            if (articleBeanOp.isPresent()) {
                ArticleBean article = articleBeanOp.get();
                System.out.println(article.getCode());
                if (panier.containsKey(article.getCode())) {
                    panier.put(article.getCode(), panier.get(article.getCode()) + 1);
                } else {
                    panier.put(article.getCode(), 1);
                }
                request.getSession().setAttribute("message", "L'article " + article.getNom() + " a bien été ajouté au panier");
                request.getSession().setAttribute("panier", panier);
                response.sendRedirect("/imt.association/accueil");
            }
        } else {
        	request.getSession().setAttribute("erreur", "Veuillez vous authentifier d'abord");
            response.sendRedirect("/imt.association/login");
        }

    }
}