<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page import="db.bean.Article"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="fr">
<head>
<meta charset="utf-8" />
<link rel="stylesheet" href="css/header.css" type="text/css">
<link rel="stylesheet" href="css/footer.css" type="text/css">
<link rel="stylesheet" href="css/articles.css" type="text/css">
<link rel="stylesheet"
	href="webjars/bootstrap/4.0.0-beta-1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="webjars/font-awesome/4.7.0/css/font-awesome.min.css">
<title>IMTAssociation - Inscription</title>
</head>

<body>
	<%@ include file="/WEB-INF/jspf/header.jspf"%>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-9 offset-md-1">
				<h3>Bienvenue à l'IMTAssociation</h3>
				<p class="text-muted">Vous trouverez ici une sélection de
					produits proposés par l'association pour subvenir à tous vos
					besoins de membre de l'IMTA</p>
				<c:forEach var="art" begin="0" end="${taille - 1}" varStatus="i"
					items="${articles}">
					<c:if test="${i.index %3==0 && i.index == 0}">
						<div class="card-deck">
							<form method="POST" action="accueil/article/${art.code }">
								<div class="card article">
									<img class="card-img-top" src="img/${art.image }"
										alt="Card image cap">
									<div class="card-body">
										<h4 class="card-title">${art.nom }</h4>
										<p class="card-text">${art.description }</p>
									</div>
									<div class="card-footer">
										<p>
											${art.prix } € <a href="#"><button
													class="btn connect ajout" type="submit">
													Ajouter au panier <span class="fa fa-cart-plus"></span>
												</button> </a>
										</p>
									</div>
								</div>
							</form>
					</c:if>

					<c:if test="${i.index %3==0 && i.index > 0}">
						</div>
						<br />
						<div class="card-deck">
							<form method="POST" action="accueil/article/${art.code }">
								<div class="card article">
									<img class="card-img-top" src="img/${art.image }" alt="Card image cap">
									<div class="card-body">
										<h4 class="card-title">${art.nom }</h4>
										<p class="card-text">${art.description }</p>
									</div>
									<div class="card-footer">
										<p>
											${art.prix } € <a href="#"><button
													class="btn connect ajout" type="submit">
													Ajouter au panier <span class="fa fa-cart-plus"></span>
												</button></a>
											</a>
										</p>
									</div>
								</div>
							</form>
				</c:if>
				<c:if test="${i.index %3!=0}">
					<form method="POST" action="accueil/article/${art.code }">
						<div class="card article">
							<img class="card-img-top" src="img/${art.image }"
								alt="Card image cap">
							<div class="card-body">
								<h4 class="card-title">${art.nom }</h4>
								<p class="card-text">${art.description }</p>
							</div>
							<div class="card-footer">
								<p>
									${art.prix } € <a href="#"><button
													class="btn connect ajout" type="submit">
													Ajouter au panier <span class="fa fa-cart-plus"></span>
												</button></a>
									</a>
								</p>
							</div>
						</div>
					</form>
				</c:if>
				<c:if test="${i.index %3 !=0 && i.index == taille -1 }">
					</div>
					<br />
				</c:if>
			</c:forEach>
		</div>
	</div>
	</div>
	<%@ include file="/WEB-INF/jspf/footer.jspf"%>
</body>

</html>