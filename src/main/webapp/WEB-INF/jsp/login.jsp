<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8" />
<link rel="stylesheet" href="css/header.css" type="text/css">
<link rel="stylesheet" href="css/footer.css" type="text/css">
<link rel="stylesheet" href="css/login.css" type="text/css">
<link rel="stylesheet"
	href="webjars/bootstrap/4.0.0-beta-1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="webjars/font-awesome/4.7.0/css/font-awesome.min.css">
<title>IMTAssociation - Connexion</title>
</head>

<body>
	<%@ include file="/WEB-INF/jspf/header.jspf"%>
	<div class="container">
		<div class="row justify-content-md-center">
			<form>
				<br />
				<div class="d-flex justify-content-center">
					<img class="logo center-block" src="img/logo.png"
						alt="Logo de l'IMTAssociation" />
				</div>
				<br />
				<h4 class="h4 text-center">
					<span class="text-muted">Veuillez vous authentifier </span>
				</h4>
				<br />
				<div class="form-group col-md-auto">
					<input class="form-control" type="text"
						placeholder="Nom d'utilisateur" /> <br /> <input
						class="form-control" type="password" placeholder="Mot de passe" />
				</div>
				<div class="form-group d-flex justify-content-end">
					<button class="btn connect" type="submit">Se connecter</button>
				</div>
			</form>
		</div>
	</div>
	<%@ include file="/WEB-INF/jspf/footer.jspf"%>
</body>
</html>