package servlets;

import java.io.IOException;
import java.util.TreeMap;
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
import db.mapper.MapperResult;
import db.bean.ArticleBean;
import db.dao.ArticleDAO;
import db.dao.DAO;

/**
 * Servlet permettant la gestion des commandes
 *
 * @author Juliette FRETAY, Kendall FOREST, Chloé GUILBAUD
 */
@WebServlet({ "/commande", "/commande/*" })
public class Commande extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getSession().getAttribute("user") != null) {
			if (request.getRequestURI().contains("commande/remove")) {
				String code = request.getRequestURI().substring(request.getRequestURI().lastIndexOf('/') + 1);
				if (code.length() == 3) {
					Map<String, Integer> panier = (TreeMap<String, Integer>) request.getSession()
							.getAttribute("panier");
					panier.remove(code);
					request.getSession().setAttribute("panier", panier);
					System.out.println(request.getSession().getAttribute("panier"));

					response.sendRedirect("/imt.association/commande");
				}
			} else if(request.getRequestURI().contains("commande/quantity")){
				String code = request.getRequestURI().substring(request.getRequestURI().lastIndexOf('/') + 1);
				Integer newQuantity = Integer.valueOf(request.getParameter("inputQuantity"));
				if (code.length() == 3) {

					Map<String, Integer> panier = (TreeMap<String, Integer>) request.getSession()
							.getAttribute("panier");
					Optional<ArticleBean> articlebeanOp = DataBaseManager.loadArticle(code, response);
					ArticleBean articleBean;
					if (articlebeanOp.isPresent()) {
						articleBean = articlebeanOp.get();
						if (newQuantity> articleBean.getStock()) {// Avec le +1 ça depasse le stock
							panier.put(code, articleBean.getStock());
						} else {
							panier.put(code, newQuantity);
						}
					}

					request.getSession().setAttribute("panier", panier);
					response.sendRedirect("/imt.association/commande");
				}
			}else if(request.getRequestURI().contains("commande/valider")){
				
					Map<ArticleBean, Integer> panierValue = (HashMap<ArticleBean, Integer>) request.getSession()
							.getAttribute("panierValue");
					Map<String, Integer> panier = (TreeMap<String, Integer>) request.getSession()
							.getAttribute("panier");
					boolean Erreurpresent = false;
					for (Map.Entry<ArticleBean, Integer> entry : panierValue.entrySet()) {
						entry.getKey().setStock(entry.getKey().getStock() - entry.getValue());
						
						Optional<ArticleBean> res = DataBaseManager.saveArticle(entry.getKey(), response);
						if (!res.isPresent()){
							Erreurpresent=true;
						}
					}
					panier = new TreeMap<String,Integer>();
					if(!Erreurpresent){
						request.getSession().setAttribute("panier", panier);
						response.sendRedirect("/imt.association/commande");
					}
					
					
				
			}else {
				response.sendRedirect("/imt.association/erreur404");
			}
		} else {
			response.sendRedirect("/imt.association/login");
		}
	}

	private void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getSession().getAttribute("user") != null) {
			if ((TreeMap) request.getSession().getAttribute("panier") == null) {
				System.out.println("Panier null");
			}
			Map<String, Integer> panier = (TreeMap) request.getSession().getAttribute("panier");

			Map<ArticleBean, Integer> panierValue = new HashMap<ArticleBean, Integer>();
			for (Map.Entry<String, Integer> entry : panier.entrySet()) {

				String key = entry.getKey();

				Optional<ArticleBean> articlebeanOp = DataBaseManager.loadArticle(key, response);
				if (articlebeanOp.isPresent()) {
					request.getSession().removeAttribute("message");
					request.getSession().removeAttribute("succes");
					ArticleBean articleBean = articlebeanOp.get();
					Integer value = entry.getValue();
					panierValue.put(articleBean, value);
				}
			}
			request.getSession().setAttribute("panierValue", panierValue);
			request.getSession().setAttribute("taillePanier",
					((TreeMap) request.getSession().getAttribute("panier")).size());


			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/commande.jsp");
			rd.forward(request, response);
		} else {
			response.sendRedirect("/imt.association/login");
		}
	}

}
