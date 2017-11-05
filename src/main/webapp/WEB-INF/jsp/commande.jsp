<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.List"%>
<%@page import="db.bean.ArticleBean"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="fr">
<head>
<meta charset="utf-8" />
<link rel="stylesheet" href="css/header.css" type="text/css">
<link rel="stylesheet" href="css/footer.css" type="text/css">
<link rel="stylesheet" href="css/commande.css" type="text/css">
<link rel="stylesheet"
	href="webjars/bootstrap/4.0.0-beta-1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="webjars/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="webjars/jquery/3.2.1/jquery.min.js"></script>
<script src="webjars/popper.js/1.12.3/dist/umd/popper.min.js"></script>
<script src="webjars/bootstrap/4.0.0-beta-1/js/bootstrap.min.js"></script>
<title>IMTAssociation - Commande</title>
</head>

<body>
	<%@ include file="/WEB-INF/jspf/header.jspf"%>
	<div class="container-fluid">
		<table class="table table-hover">
			<thead>
				<tr>
					<th>#</th>
					<th>Nom Article</th>
					<th>Prix Total</th>
					<th>Quantité</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="artPanier" begin="0" end="${taillePanier -1}"
					varStatus="i" items="${panierValue}">
					<tr>
						<th scope="row">${artPanier.key.code}</th>
						<td>${artPanier.key.nom}</td>
						<td>${artPanier.key.prix}€</td>
						<td>${artPanier.value}</td>
						<td>
							<div class="btn-toolbar" role="toolbar"
								aria-label="Toolbar with button groups">

								<div class="btn-group mr-2" role="group"
									aria-label="First group">
									<form method="POST"
										action="commande/plus/${artPanier.key.code}">
										<button type="submit" class="btn btn-success">
											<i class="fa fa-plus"></i>
										</button>
									</form>
								</div>
								<div class="btn-group mr-2" role="group"
									aria-label="Second group">
									<form method="POST"
										action="commande/minus/${artPanier.key.code}">
										<button type="submit" class="btn btn-danger">
											<i class="fa fa-minus"></i>
										</button>
									</form>
								</div>
							</div>
						</td>
						<td>
							<form method="POST"
								action="commande/remove/${artPanier.key.code}">
								<button type="submit" class="btn btn-danger">
									<i class="fa fa-trash-o"></i>
								</button>
							</form>
						</td>

					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<%@ include file="/WEB-INF/jspf/footer.jspf"%>
</body>
</script>
</html>