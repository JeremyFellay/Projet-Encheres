<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/style.css">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title> Se connecter / S'inscrire</title>
    </head>

    <header>
        <img class="logo-site-login" src="<%=request.getContextPath()%>/images/eni-encheres.svg"/>
    </header>
    
    <body class="pagelogin">
        <div class="modulelogin">
        <form action="ServletConnexion" method="post" class="formlogin">
            <h2>Se connecter / S'inscrire </h2>

              <label for="name">Email </label> <br>
              <input type="email" name="email" id="email" required /> <br>
              <label for="password">Mot de passe </label> <br>
              <input type="password" name="password" id="password" required /> <br>

                <button id="btn-connexion" type ="submit"> Se Connecter</button> <br>
                <button id="btn-inscription" action="ServletInscription" type ="submit"> S'inscrire</button>
          </form>

        </form>

    </div>
    </section>
          
    </body>
</html>