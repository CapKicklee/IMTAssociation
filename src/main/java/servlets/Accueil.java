package servlets;

import java.io.IOException;
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
import db.manager.DataBaseManager;
import db.mapper.BeanDaoMapper;
import db.mapper.Mappable;
import db.mapper.MapperResult;
import db.services.persistence.JPAPersistence;
import db.services.persistence.ArticleJPAPersistence;
import db.services.results.JPAResult;

/**
 * Servlet implementation class Accueil
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
            Optional<List<ArticleBean>> articlesOp = DataBaseManager.loadAllArticles(response);
            if (articlesOp.isPresent()) {
                List<ArticleBean> articleBeanList = articlesOp.get();
                request.setAttribute("articles", articleBeanList);

                Optional<Long> nbArticleOp = DataBaseManager.callAllArticles(response);
                if (nbArticleOp.isPresent()) {

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
