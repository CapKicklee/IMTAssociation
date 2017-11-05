<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
				</tr>
			</thead>
			<tbody>
				<tr:forEach var="artPanier" begin="0"
					end "${taillePanier -1}" varStatus="i" items="${panier}">
					<tr>
						<th scope="row">${artPanier.value.code}</th>
						<td>${artPanier.value.nom}</td>
						<td>${artPanier.value.prix}€</td>
						<td>${artPanier.key}</td>
						<td>
							<div class="btn-toolbar" role="toolbar"
								aria-label="Toolbar with button groups">

								<div class="btn-group mr-2" role="group"
									aria-label="First group">
									<button type="button" class="btn btn-success">
										<i class="fa fa-plus"></i>
									</button>
								</div>
								<div class="btn-group mr-2" role="group"
									aria-label="Second group">
									<button type="button" class="btn btn-danger">
										<i class="fa fa-minus"></i>
									</button>
								</div>
							</div>
						</td>

					</tr>
				</tr:forEach>
				<tr>
					<th scope="row">001</th>
					<td>Article 1</td>
					<td>45€</td>
					<td>1</td>
					<td>
						<div class="btn-toolbar" role="toolbar"
							aria-label="Toolbar with button groups">
							<div class="btn-group mr-2" role="group" aria-label="First group">
								<button type="button" class="btn btn-success">
									<i class="fa fa-plus"></i>
								</button>
							</div>
							<div class="btn-group mr-2" role="group"
								aria-label="Second group">
								<button type="button" class="btn btn-danger">
									<i class="fa fa-minus"></i>
								</button>
							</div>
						</div>
					</td>
				</tr>
				<tr>
					<th scope="row">002</th>
					<td>Article 2</td>
					<td>45€</td>
					<td>2</td>
					<td>
						<div class="btn-toolbar" role="toolbar"
							aria-label="Toolbar with button groups">

							<div class="btn-group mr-2" role="group" aria-label="First group">
								<button type="button" class="btn btn-success">
									<i class="fa fa-plus"></i>
								</button>
							</div>
							<div class="btn-group mr-2" role="group"
								aria-label="Second group">
								<button type="button" class="btn btn-danger">
									<i class="fa fa-minus"></i>
								</button>
							</div>
						</div>
					</td>
				</tr>
				<tr>
					<th scope="row">003</th>
					<td>Article 3</td>
					<td>90€</td>
					<td>1</td>
					<td>
						<div class="btn-toolbar" role="toolbar"
							aria-label="Toolbar with button groups">

							<div class="btn-group mr-2" role="group" aria-label="First group">
								<button type="button" class="btn btn-success">
									<i class="fa fa-plus"></i>
								</button>
							</div>
							<div class="btn-group mr-2" role="group"
								aria-label="Second group">
								<button type="button" class="btn btn-danger">
									<i class="fa fa-minus"></i>
								</button>
							</div>
						</div>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	<%@ include file="/WEB-INF/jspf/footer.jspf"%>
</body>

</html>