package servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.manager.DataBaseManager;
import db.mapper.BeanDaoMapper;

import db.bean.ArticleBean;
import db.dao.ArticleDAO;
import db.services.persistence.JPAPersistence;
import db.services.persistence.ArticleJPAPersistence;

/**
 * Servlet implementation class Commande
 */
@WebServlet({"/commande", "/commande/*"})
public class Commande extends HttpServlet {
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
        if (request.getRequestURI().contains("commande/plus")) {
            String code = request.getRequestURI().substring(request.getRequestURI().lastIndexOf('/') + 1);
            System.out.println("Code : " + code);
            if (code.length() == 3) {
                HashMap<String, Integer> panier = (HashMap<String, Integer>) request.getSession().getAttribute("panier");
                if (false) {//Avec le +1 ça depasse le stock
                    //Ne rien faire sur la quantite
                    //Avertir l'utilisateur
                } else {
                    panier.put(code, panier.get(code) + 1);
                }
                request.getSession().setAttribute("panier", panier);
                response.sendRedirect("/imt.association/commande");

            }

        }

        if (request.getRequestURI().contains("commande/minus")) {
            String code = request.getRequestURI().substring(request.getRequestURI().lastIndexOf('/') + 1);
            System.out.println("Code : " + code);
            if (code.length() == 3) {
                HashMap<String, Integer> panier = (HashMap<String, Integer>) request.getSession().getAttribute("panier");
                if (panier.get(code) - 1 == 0) {
                    panier.remove(code);
                } else {
                    panier.put(code, panier.get(code) - 1);
                }

                request.getSession().setAttribute("panier", panier);
                response.sendRedirect("/imt.association/commande");
            }
        }

        if (request.getRequestURI().contains("commande/remove")) {
            String code = request.getRequestURI().substring(request.getRequestURI().lastIndexOf('/') + 1);
            System.out.println("Code : " + code);
            if (code.length() == 3) {
                HashMap<String, Integer> panier = (HashMap<String, Integer>) request.getSession().getAttribute("panier");
                panier.remove(code);

                request.getSession().setAttribute("panier", panier);
                response.sendRedirect("/imt.association/commande");
            }
        }
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if ((HashMap) request.getSession().getAttribute("panier") == null) {
            System.out.println("Panier null");
        }
        HashMap<String, Integer> panier = (HashMap) request.getSession().getAttribute("panier");

        HashMap<ArticleBean, Integer> panierValue = new HashMap<ArticleBean, Integer>();
        for (Map.Entry<String, Integer> entry : panier.entrySet()) {

            String key = entry.getKey();

            Optional<ArticleBean> articlebeanOp = DataBaseManager.loadArticle(key, response);
            if (articlebeanOp.isPresent()) {

                ArticleBean articleBean = articlebeanOp.get();
                Integer value = entry.getValue();
                System.out.println("Création du panier : " + articleBean + " " + value);
                panierValue.put(articleBean, value);

                request.getSession().setAttribute("panierValue", panierValue);
                request.getSession().setAttribute("taillePanier", ((HashMap) request.getSession().getAttribute("panier")).size());
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/commande.jsp");
                rd.forward(request, response);

            }

        }

    }

}
