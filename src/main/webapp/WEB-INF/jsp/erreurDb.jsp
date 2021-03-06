<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/header.css" type="text/css">
<link rel="stylesheet" href="css/footer.css" type="text/css">
<link rel="stylesheet"
	href="webjars/bootstrap/4.0.0-beta-1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="webjars/font-awesome/4.7.0/css/font-awesome.min.css">
	<script src="webjars/popper.js/1.12.5/dist/umd/popper.min.js"></script>
<script src="webjars/jquery/3.2.1/jquery.min.js"></script>
<script src="webjars/bootstrap/4.0.0-beta-1/js/bootstrap.min.js"></script>
<title>IMTAssociation - Erreur</title>
</head>
<body>
<%@ include file="/WEB-INF/jspf/header.jspf" %>
<div class="container d-flex justify-content-center">
    <img src="img/db.jpg" alt="Erreur Database" class="center-block">
</div>

<div class="container d-flex justify-content-center">
    <p>T'as tout cassé... Contacte l'administrateur maintenant...</p>
</div>

<div class="container d-flex justify-content-center">
    <a href="/imt.association/accueil" class="center-block">
        <button type="button" class="btn btn-primary">Accueil</button>
    </a>
</div>
<%@ include file="/WEB-INF/jspf/footer.jspf" %>
</body>
</html>