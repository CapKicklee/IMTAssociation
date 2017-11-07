<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="fr">
<head>
<meta charset="utf-8" />
<link rel="stylesheet" href="css/header.css" type="text/css">
<link rel="stylesheet" href="css/footer.css" type="text/css">
<link rel="stylesheet" href="css/home.css" type="text/css">
<link rel="stylesheet"
	href="webjars/bootstrap/4.0.0-beta-1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="webjars/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="webjars/jquery/3.2.1/jquery.min.js"></script>
<script src="webjars/popper.js/1.12.5/dist/umd/popper.min.js"></script>
<script src="webjars/bootstrap/4.0.0-beta-1/js/bootstrap.min.js"></script>
<title>IMTAssociation - Home</title>
</head>

<body>
	<%@ include file="/WEB-INF/jspf/header.jspf"%>
	<br />
	<div class="container-fluid">
		<nav class="breadcrumb"> <span class="breadcrumb-item active">Home
		</span> </nav>
		<br />
		<div class="d-flex justify-content-center">
			<img class="logo center-block" src="img/logo.png"
				alt="Logo de l'IMTAssociation" />
		</div>
		<br />
		<div class="">
			<h2 class="text-center">Bienvenue à l'IMTAssociation</h2>
			</br>
			<h4 class="text-center text-muted">Vous trouverez sur ce site
				une sélection d'articles pour embellir votre vie à l'IMT Atlantique.</h4>
			</br>
			<ul class="fa-ul text-center">
				<h5>
					Voir la liste des articles proposés <a
						href="/imt.association/accueil"><button type="button"
							class="btn btn-info">Ici</button></a>
				</h5>
				</br>
				<h5>
					Voir mon panier d'articles commandés <a
						href="/imt.association/commande"><button type="button"
							class="btn btn-info">Là</button></a>
				</h5>
			</ul>
		</div>
		<img class="card-img-top" src="img/articles.png" alt="Card image cap">
	</div>
	<%@ include file="/WEB-INF/jspf/footer.jspf"%>
</body>
</script>
</html>