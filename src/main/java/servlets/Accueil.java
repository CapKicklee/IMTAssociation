package servlets;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.bean.ArticleBean;
import db.manager.DataBaseManager;

/**
 * Servlet permettant la gestion de la page d'accueil
 *
 * @author Juliette FRETAY, Kendall FOREST, Chloé GUILBAUD
 */
@WebServlet({"/accueil", "/accueil/*"})
public class Accueil extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getRequestURI().contains("accueil/article")) {
            request.setAttribute("article",
                    request.getRequestURI().substring(request.getRequestURI().lastIndexOf('/') + 1));
            response.sendRedirect("/imt.association/article/"
                    + request.getRequestURI().substring(request.getRequestURI().lastIndexOf('/') + 1));
        } else {
            process(request, response);
        }
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") != null) {
        	request.getSession().removeAttribute("erreur");
			request.getSession().removeAttribute("valider");
            Optional<List<ArticleBean>> articlesOp = DataBaseManager.loadAllArticles(response);
            if (articlesOp.isPresent()) {
                List<ArticleBean> articleBeanList = articlesOp.get();
                request.setAttribute("articles", articleBeanList);

                Optional<Long> nbArticleOp = DataBaseManager.countAllArticles(response);
                if (nbArticleOp.isPresent()) {
                	request.getSession().removeAttribute("message");
                    Long nbArticle = nbArticleOp.get();
                    request.setAttribute("taille", nbArticle);

                    RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/articles.jsp");
                    rd.forward(request, response);

                }

            } else {
            	request.getSession().setAttribute("message", "Il n'y a plus d'articles à afficher, désolé...");
            }
        } else {
        	request.getSession().setAttribute("erreur", "Veuillez vous authentifier d'abord");
            response.sendRedirect("/imt.association/login");
        }

    }

}
