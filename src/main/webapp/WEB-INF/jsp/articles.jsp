<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
		<div class="card-deck">
			<div class="card article">
				<img class="card-img-top" src="img/pull.jpg" alt="Card image cap">
				<div class="card-body">
					<h4 class="card-title">Pull de l'EMN</h4>
					<p class="card-text">Magnifique pull molletoné avec le logo de
						l'Ecole des Mines de Nantes brodé dessus</p>
				</div>
				<div class="card-footer">
					<p>
						45€ <a href="#" class="btn ajout">Ajouter au panier <span
							class="fa fa-cart-plus"></span>
						</a>
					</p>
				</div>
			</div>
			<div class="card article">
				<img class="card-img-top" src="img/jog.PNG" alt="Card image cap">
				<div class="card-body">
					<h4 class="card-title">Jogging de l'AS de l'EMN</h4>
					<p class="card-text">Quoi de mieux qu'un jogging aux couleurs
						de l'EMN pour aller avec ton tout nouveau pull de l'EMN ?</p>
				</div>
				<div class="card-footer">
					<p>
						45€ <a href="#" class="btn ajout">Ajouter au panier <span
							class="fa fa-cart-plus"></span>
						</a>
					</p>
				</div>
			</div>
			<div class="card article">
				<img class="card-img-top" src="img/sac.PNG" alt="Card image cap">
				<div class="card-body">
					<h4 class="card-title">Sac de l'AS de l'EMN</h4>
					<p class="card-text">T'as trop d'affaires de l'EMN à
						transporter ? Alors prend ce super sac !</p>
				</div>
				<div class="card-footer">
					<p>
						45€ <a href="#" class="btn ajout">Ajouter au panier <span
							class="fa fa-cart-plus"></span>
						</a>
					</p>
				</div>
			</div>
			<div class="card article">
				<img class="card-img-top" src="img/casquette.jpg"
					alt="Card image cap">
				<div class="card-body">
					<h4 class="card-title">Casquette de l'EMN</h4>
					<p class="card-text">La super casquette de l'EMN pour avoir le
						style en toute circonstance</p>
				</div>
				<div class="card-footer">
					<p>
						45€ <a href="#" class="btn ajout">Ajouter au panier <span
							class="fa fa-cart-plus"></span>
						</a>
					</p>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="/WEB-INF/jspf/footer.jspf"%>
</body>

</html>