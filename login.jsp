<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page import="db.bean.Pays" %>
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
<script src="webjars/jquery/3.2.1/jquery.min.js"></script>
<script src="webjars/popper.js/1.12.3/dist/umd/popper.min.js"></script>
<script src="webjars/bootstrap/4.0.0-beta-1/js/bootstrap.min.js"></script>
<script>
$('a[data-toggle="tab"]').on('shown.bs.tab', function (e) {
	  e.target // newly activated tab
	  e.relatedTarget // previous active tab
	})
</script>
<title>IMTAssociation</title>
</head>

<body>
	<!-- <%@ include file="/WEB-INF/jspf/header.jspf"%> -->
	<div class="container">
		<br/>
		<div class="d-flex justify-content-center">
			<img class="logo center-block" src="img/logo.png"
				alt="Logo de l'IMTAssociation" />
		</div>
		<br/>
		<div class="card text-center">
			<div class="card-header">
				<ul id="myTab" role="tablist" class="nav nav-tabs card-header-tabs">
					<li class="nav-item"><a class="nav-link active"
						id="connect-tab" data-toggle="tab" href="#connect" role="tab"
						aria-controls="connect" aria-selected="true">Se connecter</a></li>
					<li class="nav-item"><a class="nav-link" id="subscribe-tab"
						data-toggle="tab" href="#subscribe" role="tab"
						aria-controls="subscribe" aria-selected="false">S'inscrire</a></li>
				</ul>
			</div>
			<div class="card-body tab-content">
				<div class="tab-pane fade active show" id="connect" role="tabpanel"
					aria-labelledby="connect-tab">
					<div class="row justify-content-md-center">
						<form method="POST" action="/login/auth">
							<br /> <br />
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
				<div class="tab-pane fade" id="subscribe" role="tabpanel"
					aria-labelledby="subscribe-tab">
					<form method="POST" action="/login/create" class="col-md-9 offset-md-2">
						<h3 class="text-muted">Rejoignez-nous !</h3>
						<br />
						<div class="form-group row">
							<label for="login" class="col-sm-3 col-form-label">Nom
								d'utilisateur <span style="color: red">*</span>
							</label>
							<div class="col-sm-9">
								<input type="text" class="form-control" id="login"
									placeholder="Nom d'utilisateur" required>
							</div>
						</div>
						<div class="form-group row">
							<label for="password" class="col-sm-3 col-form-label">Mot
								de passe <span style="color: red">*</span>
							</label>
							<div class="col-sm-9">
								<input type="password" class="form-control" id="password"
									placeholder="Mot de passe" required>
							</div>
						</div>
						<div class="form-group row">
							<label for="password2" class="col-sm-3 col-form-label">Confirmez
								votre mot de passe <span style="color: red">*</span>
							</label>
							<div class="col-sm-9">
								<input type="password" class="form-control" id="password2"
									placeholder="Confirmez votre mot de passe" required>
							</div>
						</div>
						<div class="form-group row">
							<label for="nom" class="col-sm-3 col-form-label">Nom de
								famille <span style="color: red">*</span>
							</label>
							<div class="col-sm-9">
								<input type="text" class="form-control" id="nom"
									placeholder="Nom de famille" required>
							</div>
						</div>
						<div class="form-group row">
							<label for="prenom" class="col-sm-3 col-form-label">Prénom
								<span style="color: red">*</span>
							</label>
							<div class="col-sm-9">
								<input type="text" class="form-control" id="prenom"
									placeholder="Prénom" required>
							</div>
						</div>
						<div class="form-group row">
							<label for="rue" class="col-sm-3 col-form-label">Adresse</label>
							<div class="col-sm-9">
								<input type="text" class="form-control" id="rue"
									placeholder="Nom de rue">
							</div>
						</div>
						<div class="form-group row">
							<label for="cp" class="col-sm-3 col-form-label">Code
								postal</label>
							<div class="col-sm-9">
								<input type="number" class="form-control" id="cp"
									placeholder="Code postal">
							</div>
						</div>
						<div class="form-group row">
							<label for="ville" class="col-sm-3 col-form-label">Ville</label>
							<div class="col-sm-9">
								<input type="text" class="form-control" id="ville"
									placeholder="Ville">
							</div>
						</div>
						<div class="form-group row">
							<label for="pays" class="col-sm-3 col-form-label">Pays</label>
							<div class="col-sm-9">
								<select id="pays" class="form-control">
									<c:forEach var="pays" begin="0" items="${paysListe}">
										<option value="${pays.code }">${pays.nom }</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<button type="submit" class="btn sub">S'inscrire</button>
						<br />
					</form>
				</div>
				<!-- </div>-->
			</div>
		</div>
	</div>
	<br/>
	<%@ include file="/WEB-INF/jspf/footer.jspf"%>
</body>
</html>