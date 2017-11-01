<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8" />
    <link rel="stylesheet" href="webjars/bootstrap/4.0.0-beta-1/css/bootstrap.min.css">
    <link rel="stylesheet" href="./WEB-INF/css/header.css" type="text/css">
    <link rel="stylesheet" href="webjars/font-awesome/4.7.0/css/font-awesome.min.css">
    <title>IMTAssociation - Connexion</title>
</head>

<body>
	<%@ include file="/WEB-INF/jspf/header.jspf" %>
	<div class="container">
        <div class="row justify-content-md-center">
            <h1>Bienvenue sur le site d'IMTAssociation<span class="text-muted">, veuillez vous authentifier</span></h1>
            <form>
                <div class="form-group col-md-auto">
                    <input class="form-control" type="text" placeholder="Nom d'utilisateur" />
                    <input class="form-control" type="password" placeholder="Mot de passe" />
                </div>
                <div class="form-group">
                    <button class="btn btn-primary" type="submit">Se connecter</button>
                </div>
            </form>
        </div>
    </div>
	<%@ include file="/WEB-INF/jspf/footer.jspf" %>
</body>
</html>