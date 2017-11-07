<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page import="db.bean.ArticleBean"%>
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
<script src="webjars/jquery/3.2.1/jquery.min.js"></script>
<script src="webjars/popper.js/1.12.3/dist/umd/popper.min.js"></script>
<script src="webjars/bootstrap/4.0.0-beta-1/js/bootstrap.min.js"></script>
<title>IMTAssociation - Achats</title>
</head>

<body>
	<%@ include file="/WEB-INF/jspf/header.jspf"%>
	<br />
	<div class="container-fluid">
		<c:if test="${erreur != null }">
			<div class="alert alert-danger alert-dismissible fade show"
				role="alert">${erreur }
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
		</c:if>
		<c:if test="${message != null }">
			<div class="alert alert-warning alert-dismissible fade show"
				role="alert">${message }
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
		</c:if>
		<c:if test="${succes != null }">
			<div class="alert alert-success alert-dismissible fade show"
				role="alert">${succes }
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
		</c:if>
		<nav class="breadcrumb"> <a class="breadcrumb-item"
			href="/imt.association/home">Home </a> <span
			class="breadcrumb-item active">Articles </span> </nav>
		<div class="row justify-content-md-center">
			<div class="col-md-10">
				<h3 class="text-center">Bienvenue à l'IMTAssociation</h3>
				<p class="text-center text-muted">Vous trouverez ici une
					sélection d'articles pour embellir votre vie à l'IMT Atlantique</p>
			</div>
		</div>
		<c:forEach var="art" begin="0" end="${taille}" varStatus="i"
			items="${articles}">
			<c:if test="${i.index %3==0 && i.index == 0}">
				<div class="row justify-content-md-center">
					<div class="col-md-10">
						<div class="card-deck">

							<div class="card article">
								<img class="card-img-top" src="img/${art.image }"
									alt="Card image cap">
								<div class="card-body">
									<h4 class="card-title">${art.nom }</h4>
									<p class="card-text">${art.description }</p>
								</div>
								<div class="card-footer">
									<form method="POST" action="article/${art.code }">
										<span class="col-md-3">${art.prix } € </span> <a href="#"
											class="col-md-8"><button class="btn connect ajout"
												type="submit">
												Ajouter au panier <span class="fa fa-cart-plus"></span>
											</button> </a>
									</form>
								</div>
							</div>
			</c:if>

			<c:if test="${i.index %3==0 && i.index > 0}">
	</div>
	</div>
	</div>
	<br />
	<div class="row justify-content-md-center">
		<div class="col-md-10">
			<div class="card-deck">
				<div class="card article">
					<img class="card-img-top" src="img/${art.image }"
						alt="Card image cap">
					<div class="card-body">
						<h4 class="card-title">${art.nom }</h4>
						<p class="card-text">${art.description }</p>
					</div>
					<div class="card-footer">
						<form method="POST" action="article/${art.code }">
							<span class="col-md-3">${art.prix } € </span> <a href="#"
								class="col-md-8"><button class="btn connect ajout"
									type="submit">
									Ajouter au panier <span class="fa fa-cart-plus"></span>
								</button> </a>
						</form>
					</div>

				</div>
				</c:if>
				<c:if test="${i.index %3!=0}">
					<div class="card article">
						<img class="card-img-top" src="img/${art.image }"
							alt="Card image cap">
						<div class="card-body">
							<h4 class="card-title">${art.nom }</h4>
							<p class="card-text">${art.description }</p>
						</div>
						<div class="card-footer">
							<form method="POST" action="article/${art.code }">
								<span class="col-md-3">${art.prix } € </span> <a href="#"
									class="col-md-8"><button class="btn connect ajout"
										type="submit">
										Ajouter au panier <span class="fa fa-cart-plus"></span>
									</button> </a>
							</form>
						</div>
					</div>
				</c:if>
				<c:if test="${i.index %3 !=0 && i.index == taille -1 }">
			</div>
		</div>
	</div>
	<br />
	</c:if>
	</c:forEach>
	</div>
	<br />
	<%@ include file="/WEB-INF/jspf/footer.jspf"%>
</body>

</html>