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
import db.mapper.BeanDaoMapper;
import db.mapper.Mappable;
import db.services.persistence.JPAPersistence;
import db.services.persistence.ArticleJPAPersistence;

/**
 * Servlet implementation class Accueil
 */
@WebServlet({"/erreurDB", "/erreurDB/*"})
public class ErreurDatabase extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private JPAPersistence<ArticleDAO, String> articleJPA = new ArticleJPAPersistence();

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
            process(request, response);
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //response.sendRedirect("");
        System.out.println("Erreur database");
    }
}
